package com.clem.narakaistudio.api;

import com.clem.narakaistudio.service.UserService;
import com.clem.narakaistudio.service.model.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
//提供REST数据接口
public class UserAPI {

    private final static int DEFAULT_SIZE = 10;

    private final UserService userService;

    @GetMapping("/api/user/new")
    public List<User> newUsers(){
        return userService.getNewUsers(DEFAULT_SIZE);
    }

    @GetMapping("/api/user/active")
    public List<User> activeUsers(){
        return userService.getActiveUsers(DEFAULT_SIZE);
    }

    @GetMapping("/api/user/{userId}")
    public User userInfo(@PathVariable("userId") Long userId){
        return userService.getUserInfo(userId);
    }

    @GetMapping("/api/user/popular")
    public List<User> popularUsers(){
        return userService.getPopularUsers(DEFAULT_SIZE);
    }

    @GetMapping("/user/{userId}/fans/{page}")
    public List<User> fans(@PathVariable("userId") Long userId, @PathVariable("page") Integer page){
        return (page < 1) ? null : userService.getFans(userId, page);
    }

    @GetMapping("/user/{userId}/idols/{page}")
    public List<User> idols(@PathVariable("userId") Long userId, @PathVariable("page") Integer page){
        return (page < 1) ? null : userService.getIdols(userId, page);
    }

}
