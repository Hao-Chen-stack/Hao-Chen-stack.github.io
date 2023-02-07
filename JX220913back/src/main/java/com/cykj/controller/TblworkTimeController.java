package com.cykj.controller;


import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblmanager;
import com.cykj.bean.Tblworktime;
import com.cykj.service.TblworkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/workTime",produces = "text/html;charset=utf-8")
public class TblworkTimeController {

    @Autowired
    private TblworkTimeService tblworkTimeService;

    @RequestMapping("/workTimeList")
    @ResponseBody
    public String workTimeList(HttpSession session){
        Tblmanager manager = (Tblmanager) session.getAttribute("admin");
        List<Tblworktime> workTimeList = tblworkTimeService.findWorkTimeByMacc(manager.getManagerAcc());
        return JSON.toJSONString(workTimeList);
    }

    @RequestMapping("/addWorkTimeAndDate")
    @ResponseBody
    public String addWorkTimeAndDate(@RequestParam("times[]") List<String> times, String date, HttpSession session){
        Tblmanager manager = (Tblmanager) session.getAttribute("admin");
        int i = tblworkTimeService.addTimeAndDate((int) manager.getManagerId(), times, date);
        return String.valueOf(i);
    }

}
