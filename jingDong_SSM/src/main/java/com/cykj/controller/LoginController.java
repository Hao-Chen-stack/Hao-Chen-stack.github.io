package com.cykj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login2")
    public String login(String acc, String pwd,String code,HttpSession session){
        System.out.println(acc+","+pwd);
        System.out.println("用户输入的验证码为"+code);
        System.out.println("正确的验证码："+(session.getAttribute("strCode")));
        session.setAttribute("user","聪明的远辉");
        return "home";
    }
}
