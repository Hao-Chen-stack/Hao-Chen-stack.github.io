package com.cykj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    //登入
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        return "login";
    }

    @RequestMapping("/back")
    public String BackManager(){
        return "BackManager";
    }

    @RequestMapping("/userList")
    public String userList(){
        return "user";
    }

    @RequestMapping("/managerList")
    public String managerList(){
        return "manager";
    }

    @RequestMapping("/billList")
    public String billList(){
        return "billByMAcc";
    }

    @RequestMapping("/workTime")
    public String workTime(){
        return "workTime";
    }

    @RequestMapping("/rolepower")
    public String rolepower(){
        return "rolepower";
    }

    @RequestMapping("/DoctorAppointList")
    public String DoctorAppointList(){
        return "DoctorAppointList";
    }

    @RequestMapping("/AppointmentDetails")
    public String AppointmentDetails(){
        return "AppointmentDetails";
    }

    @RequestMapping("/UserEvaluation")
    public String UserEvaluation(){
        return "UserEvaluation";
    }

    @RequestMapping("/DiagnosticResponse")
    public String DiagnosticResponse(){
        return "DiagnosticResponse";
    }

    @RequestMapping("/AdminAppointList")
    public String AdminAppointList(){
        return "AdminAppointList";
    }

    @RequestMapping("/UserAssessment")
    public String UserAssessment(){
        return "UserAssessment";
    }

    @RequestMapping("/ReportContext")
    public String ReportContext(){
        return "ReportContext";
    }

    @RequestMapping("/StopAppointWin")
    public String StopAppointWin(){
        return "StopAppointWin";
    }

    @RequestMapping("/paperAdmin")
    public String paperAdmin(){
        return "paperAdmin";
    }

    @RequestMapping("/UserCount")
    public String UserCount(){
        return "UserCount";
    }

    @RequestMapping("/DoctorAppointCount")
    public String DoctorAppointCount(){
        return "DoctorAppointCount";
    }
}
