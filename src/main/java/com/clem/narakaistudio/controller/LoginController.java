package com.clem.narakaistudio.controller;

import com.clem.narakaistudio.service.UserService;
import com.clem.narakaistudio.service.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LoginController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginGet(@ModelAttribute User user) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        User registeredUser = userService.getUserInfo(user.getNickname(), user.getPassword());
        if (registeredUser != null) {
            return "/index";
        } else {
            return "/register";
        }
    }

    @GetMapping("/register")
    public String registerGet(@ModelAttribute User user) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        User registerUser = userService.register(user);
        if (registerUser != null) {
            return "/login";
        } else {
            return "/register";
        }
    }
}
