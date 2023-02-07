package com.cykj.controller;


import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblappointment;
import com.cykj.bean.Tblbill;
import com.cykj.bean.Tblmanager;
import com.cykj.bean.Tbluser;
import com.cykj.service.TblappointmentService;
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
    private TblmanagerService tblmanagerService;

    @Autowired
    private TbluserService tbluserService;

    @RequestMapping("/findAppointListByMAcc")
    @ResponseBody
    public String findAppointListByMAcc(String startDate, String endDate,Tblappointment tblappointment,HttpSession session,int page, int size){
        page = (page-1)*size;

        Tblmanager tblmanager = (Tblmanager) session.getAttribute("admin");

        tblappointment.setManagerAcc(tblmanager.getManagerAcc());
        List<Tblappointment> appointListByMAcc = tblappointmentService.findAppointListByMAcc(startDate, endDate,tblappointment,page,size);
        int appointCount = tblappointmentService.findAppointCount(startDate, endDate, tblappointment);

        Map<String,Object> map = new HashMap<>();
        map.put("data",appointListByMAcc);
        map.put("counts",appointCount);
        return JSON.toJSONString(map);

    }

    @RequestMapping("/appointmentDetails")
    @ResponseBody
    public String appointmentDetails(long appointmentId,long userId,String managerAcc){
        List<Tblappointment> listByAppointId = tblappointmentService.findAppointListByAppointId(appointmentId);
        String realName = tblmanagerService.findRealNameByAcc(managerAcc);
        List<Tbluser> userNameByIdList = tbluserService.findUserNameById(userId);

        Map<String,Object> map = new HashMap<>();
        map.put("listByAppointId",listByAppointId);
        map.put("realName",realName);
        map.put("userNameByIdList",userNameByIdList);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/findAppointListByAppointId")
    @ResponseBody
    public String findAppointListByAppointId(long appointmentId){
        List<Tblappointment> appointListByAppointId = tblappointmentService.findAppointListByAppointId(appointmentId);
        return JSON.toJSONString(appointListByAppointId);
    }

    @RequestMapping("/addAnswer")
    @ResponseBody
    public String addAnswer(String answer,long appointmentId){
        int i = tblappointmentService.updateAnswerByAppointId(answer, appointmentId);
        return String.valueOf(i);
    }

    @RequestMapping("/updateAppointState")
    @ResponseBody
    public String updateAppointState(long appointmentId){
        int i = tblappointmentService.updateAppointStateByAppointId(appointmentId);
        return String.valueOf(i);
    }

    //比对咨询师的费用和用户的余额方便进行扣款处理
    @RequestMapping("/compareMPriceAndUBalance")
    @ResponseBody
    public String compareMPriceAndUBalance(long userId,String managerAcc){
        double userBalanceByUId = tbluserService.findUserBalanceByUId(userId);
        double priceByAcc = tblmanagerService.findPriceByAcc(managerAcc);

        int i;
        if (userBalanceByUId>=priceByAcc){
            i = 1;
        }else {
            i = -1;
        }
        return String.valueOf(i);
    }

    //根据预约id修改预约状态为预约失败
    @RequestMapping("/updateAppointStateByUId")
    @ResponseBody
    public String updateAppointStateByUId(long appointmentId){
        int i = tblappointmentService.updateAppointStateByUId(appointmentId);
        return String.valueOf(i);
    }

    //分条件查询管理员端的预约列表及总条数
    @RequestMapping("/findAppointListBySomeCondition")
    @ResponseBody
    public String findAppointListBySomeCondition(String startDate, String endDate, Tblappointment tblappointment, int page, int size){
        page = (page-1)*size;
        List<Tblappointment> appointListBySomeCondition = tblappointmentService.findAppointListBySomeCondition(startDate, endDate, tblappointment, page, size);
        int appointCount = tblappointmentService.findAppointListCountBySomeCondition(startDate, endDate, tblappointment);

        Map<String,Object> map = new HashMap<>();
        map.put("data",appointListBySomeCondition);
        map.put("counts",appointCount);
        return JSON.toJSONString(map);
    }

    //根据预约id修改预约状态为已终止
    @RequestMapping("/updateAppointStateToStopByUId")
    @ResponseBody
    public String updateAppointStateToStopByUId(long appointmentId){
        int i = tblappointmentService.updateAppointStateToStopByUId(appointmentId);
        return String.valueOf(i);
    }

    //提示弹窗告知咨询师已终止的预约单子
    @RequestMapping("/showWinByStopForDoctor")
    @ResponseBody
    public String showWinByStopForDoctor(String managerAcc,HttpSession session){
        Tblmanager tblmanager = (Tblmanager) session.getAttribute("admin");
        managerAcc = tblmanager.getManagerAcc();
        List<Tblappointment> stopAppointList = tblappointmentService.showWinByStopForDoctor(managerAcc);
        return JSON.toJSONString(stopAppointList);
    }

    //查询已终止的预约单子总条数
    @RequestMapping("/stopAppointCount")
    @ResponseBody
    public String stopAppointCount(String managerAcc,HttpSession session){
        Tblmanager tblmanager = (Tblmanager) session.getAttribute("admin");
        managerAcc = tblmanager.getManagerAcc();
        int i = tblappointmentService.stopAppointCount(managerAcc);
        return JSON.toJSONString(i);
    }


    //咨询师点击不再提醒后修改弹窗的状态
    @RequestMapping("/updateManagerStopAns")
    @ResponseBody
    public String updateManagerStopAns(String managerAcc,HttpSession session){
        Tblmanager tblmanager = (Tblmanager) session.getAttribute("admin");
        managerAcc = tblmanager.getManagerAcc();
        int i = tblappointmentService.updateManagerStopAns(managerAcc);
        return JSON.toJSONString(i);
    }

    //咨询师预约统计
    @RequestMapping("/findDoctorAppointCount")
    @ResponseBody
    public String findDoctorAppointCount(String startDate, String endDate,Tblappointment tblappointment){
        List<Tblappointment> doctorAppointCount = tblappointmentService.findDoctorAppointCount(startDate,endDate,tblappointment);
        return JSON.toJSONString(doctorAppointCount);
    }



}
