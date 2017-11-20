package com.clem.narakaistudio.service.impl;

import com.clem.narakaistudio.constant.LoginTypeEnum;
import com.clem.narakaistudio.service.UserService;
import com.clem.narakaistudio.service.mapper.UserMapper;
import com.clem.narakaistudio.service.model.User;
import com.clem.narakaistudio.tools.UUIDUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final static int USER_SIZE = 20;

    private final UserMapper userMapper;

    @Override
    public User updateUserInfo(User user) {
        String openId = user.getOpenId();
        String avatar = user.getAvatar();
        avatar = avatar.replace("http:","");
        user.setAvatar(avatar);
        User origin = userMapper.selectByOpenId(openId);
        if (origin == null){
            // 首次登陆
            log.info("INSERT : " + user.toString());
            userMapper.insert(user);

        }else {
            // 再次登陆，信息与之前不一致，则更新
            String md5 = user.getMd5();
            String originMd5 = origin.getMd5();
            if (originMd5 != null && !md5.equals(originMd5)){
                userMapper.update(user);
            }
            user.setId(origin.getId());
        }
        return user;
    }

    @Override
    public User register(User user) {
        user.setOpenId(UUIDUtil.getShortUuid());
        user.setLoginType(LoginTypeEnum.WEB.name());
        user.setAvatar("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
        User origin = userMapper.selectByName(user.getNickname());
        if (origin == null){
            userMapper.insert(user);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User getUserInfo(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public List<User> getNewUsers(int size) {
        return userMapper.selectNew(size);
    }

    @Override
    public List<User> getActiveUsers(int size) {
        return userMapper.selectActive(size);
    }

    @Override
    public List<User> getPopularUsers(int size) {
        return userMapper.selectPopular(size);
    }

    @Override
    public List<User> getFans(Long userId, int page) {
        int begin = (page - 1) * USER_SIZE;
        return userMapper.selectFans(userId, begin, USER_SIZE);
    }

    @Override
    public List<User> getIdols(Long userId, int page) {
        int begin = (page - 1) * USER_SIZE;
        return userMapper.selectIdols(userId, begin, USER_SIZE);
    }
}
