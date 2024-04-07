package com.example.MyRadiostation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MainPageController {
    @GetMapping("/")
    public String homePage(Model model){
        return "home";
    }
}
