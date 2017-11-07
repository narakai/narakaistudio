package com.clem.narakaistudio.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class indexController {

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }
}