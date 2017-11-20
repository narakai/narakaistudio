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
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
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
