package com.clem.narakaistudio.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
//渲染页面
public class UserController {

//    private final HubService hubService;
//
//    private final UserService userService;
//
//    private final AttentionService attentionService;
//
//    /**
//     * 个人中心
//     */
//    @GetMapping("/user")
//    public String user(@AuthenticationPrincipal UsernamePasswordAuthenticationToken authenticationToken, Model model) {
//        User user = (User) authenticationToken.getPrincipal();
//        model.addAttribute("user", user);
//        List<Hub> hubs = hubService.getByUserId(user.getId());
//        model.addAttribute("hubs", hubs);
//        List<User> idols = userService.getIdols(user.getId(), 1);
//        model.addAttribute("idols", idols);
//        List<User> fans = userService.getFans(user.getId(), 1);
//        model.addAttribute("fans", fans);
//        return "user";
//    }
//
//    /**
//     * 查看他人资料
//     */
//    @GetMapping("/info/{id}")
//    public String user(@AuthenticationPrincipal UsernamePasswordAuthenticationToken authenticationToken, @PathVariable("id") Long userId, Model model) {
//        if (authenticationToken != null){
//            User user = (User) authenticationToken.getPrincipal();
//            if (userId.equals(user.getId())){
//                return "redirect:/user";
//            }
//            boolean isAttention = attentionService.isAttention(user.getId(), userId);
//            model.addAttribute("isAttention", isAttention);
//        }
//        User other = userService.getUserInfo(userId);
//        model.addAttribute("user", other);
//        List<Hub> hubs = hubService.getByUserId(userId);
//        model.addAttribute("hubs", hubs);
//        return "info";
//    }

}
