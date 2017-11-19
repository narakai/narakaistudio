package com.clem.narakaistudio.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class LoginController {
    @GetMapping("/login")
    public String home(Model model) {
        return "login";
    }
}
