package com.microcalc.fe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeController {

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }
}
