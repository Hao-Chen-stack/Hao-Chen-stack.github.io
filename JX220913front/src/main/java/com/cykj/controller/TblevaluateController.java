package com.cykj.controller;


import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblappointment;
import com.cykj.bean.Tblevaluate;
import com.cykj.service.TblevaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/evaluate",produces = "text/html;charset=utf-8")
public class TblevaluateController {
    @Autowired
    private TblevaluateService tblevaluateService;

    @RequestMapping("/findEvaListByMAcc")
    @ResponseBody
    public String findEvaListByMAcc(String managerAcc){
        List<Tblevaluate> evaListByMAcc = tblevaluateService.findEvaListByMAcc(managerAcc);
        return JSON.toJSONString(evaListByMAcc);
    }


    @RequestMapping("/addEvaluate")
    @ResponseBody
    public String addEvaluate(Tblevaluate tblevaluate, HttpSession session){
        tblevaluate.setUserAcc((String) session.getAttribute("userAcc"));
        int i = tblevaluateService.addUserEva(tblevaluate);
        return String.valueOf(i);
    }

    @RequestMapping("/updateAppointState")
    @ResponseBody
    public String updateAppointState(Tblappointment tblappointment){
        int i = tblevaluateService.updateAppointState(tblappointment);
        return String.valueOf(i);
    }


}
