package com.cykj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class pageController {
    @RequestMapping("/manager")
    public String manager(){
        return "manager";
    }

    @RequestMapping("/region")
    public String region(){
        return "region";
    }

    @RequestMapping("/Code")
    public String code(){
        return "Code";
    }

    @RequestMapping("/login")
    public String login(){
        return "loginCode";
    }

    @RequestMapping("/rolepower")
    public String rolepower(){
        return "rolepower";
    }

    @RequestMapping("/goodsList")
    public String goods(){
        return "goods";
    }

}
