package com.cykj.controller;

import com.cykj.bean.Tbluser;
import com.cykj.service.TbluserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user",produces = "text/html;charset=utf-8")
public class TbluserController {

    @Autowired
    private TbluserService tbluserService;

    @RequestMapping("/findUser")
    @ResponseBody
    public String findUser(String userAcc, String userPwd, String userCode, HttpSession session) {
        System.out.println("用户输入的验证码为" + userCode);
        System.out.println("正确的验证码：" + (session.getAttribute("strCode")));
        int i;
        if ((session.getAttribute("strCode")).equals(userCode)) {
            i = tbluserService.findUser(userAcc, userPwd);
            session.setAttribute("userAcc", userAcc);

            Tbluser tbluser = new Tbluser();
            tbluser.setUserAcc(userAcc);
            tbluser.setUserAcc(userPwd);

            session.setAttribute("admin", tbluser);
        } else {
            i = 2;
        }
        return String.valueOf(i);
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String register(Tbluser tbluser, String userAcc, String userPwd, String surePwd) {
        int k;
        if (userPwd.equals(surePwd)) {
            int q = tbluserService.findAcc(userAcc);
            if (q == 0) {
                k = tbluserService.addUser(tbluser);
            } else {
                k = 2;
            }
        } else {
            k = 3;
        }
        return String.valueOf(k);
    }


    @RequestMapping("/updateUserBalance")
    @ResponseBody
    public String updateUserBalance(double code, String userAcc,HttpSession session) {
        userAcc = (String) session.getAttribute("userAcc");
        int i = tbluserService.updateUserBalance(code, userAcc);
        return String.valueOf(i);
    }

    @RequestMapping("/updateUserBalanceByUAccForPaper")
    @ResponseBody
    public String updateUserBalanceByUAccForPaper(String userAcc,HttpSession session) {
        userAcc = (String) session.getAttribute("userAcc");
        int i = tbluserService.updateUserBalanceByUAccForPaper(userAcc);
        return String.valueOf(i);
    }

    @RequestMapping("/findUserBalanceByUAcc")
    @ResponseBody
    public String findUserBalanceByUAcc(String userAcc,HttpSession session) {
        userAcc = (String) session.getAttribute("userAcc");
        double userBalanceByUAcc = tbluserService.findUserBalanceByUAcc(userAcc);

        int i;
        if (userBalanceByUAcc>=100){
            i = 1;
        }else {
            i = -1;
        }
        return String.valueOf(i);
    }

}
