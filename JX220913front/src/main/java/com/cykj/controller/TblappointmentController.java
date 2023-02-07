package com.cykj.controller;


import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblappointment;
import com.cykj.bean.Tblarea;
import com.cykj.bean.Tblmanager;
import com.cykj.bean.Tbluser;
import com.cykj.service.TblappointmentService;
import com.cykj.service.TblareaService;
import com.cykj.service.TblmanagerService;
import com.cykj.service.TbluserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/appointment",produces = "text/html;charset=utf-8")
public class TblappointmentController {
    @Autowired
    private TblappointmentService tblappointmentService;
    @Autowired
    private TblareaService tblareaService;
    @Autowired
    private TbluserService tbluserService;
    @Autowired
    private TblmanagerService tblmanagerService;

    @RequestMapping("/findAppointList")
    @ResponseBody
    public String findAppointList(Tblappointment tblappointment,int page,int size,HttpSession session){
        page = (page-1)*size;

        tblappointment.setUserAcc((String) session.getAttribute("userAcc"));
        List<Tblappointment> appointList = tblappointmentService.findAppointList(tblappointment,page,size);
        int counts = tblappointmentService.findAppointCount(tblappointment);

        Map<String,Object> map = new HashMap<>();
        map.put("data",appointList);
        map.put("counts",counts);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/findRealName")
    @ResponseBody
    public String findRealName(String areaName){
        List<Tblmanager> doctorMsgList = tblappointmentService.findRealName(areaName);
        return JSON.toJSONString(doctorMsgList);
    }

    @RequestMapping("/doctorMsg")
    @ResponseBody
    public String doctorMsg(String managerAcc){
        List<Tblmanager> doctorMsgList = tblappointmentService.doctorMsg(managerAcc);
        List<Tblarea> areaNameList = tblareaService.findAreaNameByMAcc(managerAcc);

        Map<String,Object> map = new HashMap<>();
        map.put("doctorMsgList",doctorMsgList);
        map.put("areaNameList",areaNameList);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/addUserCheckMsg")
    @ResponseBody
    public String addUserCheckMsg(Tblappointment tblappointment, HttpSession session){
        tblappointment.setUserAcc((String) session.getAttribute("userAcc"));
//        System.out.println("........................."+session.getAttribute("userAcc"));
        int i = tblappointmentService.addUserCheckMsg(tblappointment);
//        System.out.println("领域名字为"+tblappointment.getAreaName());
//        System.out.println("领域id为"+tblappointment.getAreaId());
//        System.out.println("医生账户为为"+tblappointment.getManagerAcc());
        return String.valueOf(i);
    }

    @RequestMapping("/updateWorkTimeState")
    @ResponseBody
    public String updateWorkTimeState(int timeState){
        int i = tblappointmentService.updateWorkTimeState(timeState);
        return String.valueOf(i);
    }

    @RequestMapping("/appointmentDetails")
    @ResponseBody
    public String appointmentDetails(long appointmentId,long userId,String managerAcc){
        List<Tblappointment> listByAppointId = tblappointmentService.findAppointListByAppointId(appointmentId);
        List<Tblmanager> realNameByAccList = tblmanagerService.findRealNameByAcc(managerAcc);
        List<Tbluser> userNameByIdList = tbluserService.findUserNameById(userId);

        Map<String,Object> map = new HashMap<>();
        map.put("listByAppointId",listByAppointId);
        map.put("realNameByAccList",realNameByAccList);
        map.put("userNameByIdList",userNameByIdList);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/updateCompleteTimeByAppointmentId")
    @ResponseBody
    public String updateCompleteTimeByAppointmentId(long appointmentId){
        int i = tblappointmentService.updateCompleteTimeByAppointmentId(appointmentId);
        return JSON.toJSONString(i);
    }

    @RequestMapping("/showWinByStopForUser")
    @ResponseBody
    public String showWinByStopForUser(String userAcc,HttpSession session){
        List<Tblappointment> showWinByStopForUserList = tblappointmentService.showWinByStopForUser((String) session.getAttribute("userAcc"));
        return JSON.toJSONString(showWinByStopForUserList);
    }

    @RequestMapping("/stopAppointCount")
    @ResponseBody
    public String stopAppointCount(String userAcc,HttpSession session){
        int i = tblappointmentService.stopAppointCount((String) session.getAttribute("userAcc"));
        return String.valueOf(i);
    }

    @RequestMapping("/updateUserStopAns")
    @ResponseBody
    public String updateUserStopAns(String userAcc,HttpSession session){
        int i = tblappointmentService.updateUserStopAns((String) session.getAttribute("userAcc"));
        return String.valueOf(i);
    }



}
