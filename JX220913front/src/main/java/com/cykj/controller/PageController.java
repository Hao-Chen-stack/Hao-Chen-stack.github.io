package com.cykj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logon")
    public String logon(){
        return "register";
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        return "login";
    }


    @RequestMapping("/appointmentList")
    public String appointmentList(){
        return "appointment";
    }


    @RequestMapping("/userIndex")
    public String userIndex(){
        return "userIndex";
    }

    @RequestMapping("/IWantAppointment")
    public String IWantAppointment(){
        return "IWantAppointment";
    }

    @RequestMapping("/ConsultantFile")
    public String ConsultantFile(){
        return "ConsultantFile";
    }

    @RequestMapping("/UserEvaluation")
    public String UserEvaluation(){
        return "UserEvaluation";
    }

    @RequestMapping("/AppointmentDetails")
    public String AppointmentDetails(){
        return "AppointmentDetails";
    }

    @RequestMapping("/managerEvaluation")
    public String managerEvaluation(){
        return "managerEvaluation";
    }

    @RequestMapping("/MyReport")
    public String MyReport(){
        return "MyReport";
    }

    @RequestMapping("/ReportContext")
    public String ReportContext(){
        return "ReportContext";
    }

    @RequestMapping("/onlineAss")
    public String onlineAss(){
        return "onlineAss";
    }

    @RequestMapping("/paper")
    public String paper(){
        return "paper";
    }

    @RequestMapping("/billByUserAcc")
    public String billByUserAcc(){
        return "billByUserAcc";
    }

    @RequestMapping("/StopAppointWin")
    public String StopAppointWin(){
        return "StopAppointWin";
    }

}
