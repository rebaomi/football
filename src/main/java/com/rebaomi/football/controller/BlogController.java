package com.rebaomi.football.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
    
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","hello");
        return "index";
    }
    
}
