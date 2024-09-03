package com.pwork.pw1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/PW1")
public class ProjectMenuController {

    @RequestMapping("/menu")
    public String getMenu(){
        return "menu";
    }
}
