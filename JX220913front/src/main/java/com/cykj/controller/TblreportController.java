package com.cykj.controller;

import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblappointment;
import com.cykj.bean.Tblreport;
import com.cykj.service.TblreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/report",produces = "text/html;charset=utf-8")
public class TblreportController {
    @Autowired
    private TblreportService tblreportService;

    @RequestMapping("/findReportListByUAcc")
    @ResponseBody
    public String findReportListByUAcc(String userAcc, HttpSession session,int page,int size){
        page = (page-1)*size;

        userAcc = (String) session.getAttribute("userAcc");
        List<Tblreport> reportListByUAcc = tblreportService.findReportListByUAcc(userAcc,page,size);
        int reportCount = tblreportService.findReportCount(userAcc);

        Map<String,Object> map = new HashMap<>();
        map.put("data",reportListByUAcc);
        map.put("counts",reportCount);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/findContextAndResByDate")
    @ResponseBody
    public String findContextAndResByDate(long reportId){
        List<Tblreport> contextAndResByDateList = tblreportService.findContextAndResByDate(reportId);
        return JSON.toJSONString(contextAndResByDateList);
    }

    @RequestMapping("/addReportMsg")
    @ResponseBody
    public String addReportMsg(Tblreport tblreport,HttpSession session){
        String userAcc = (String) session.getAttribute("userAcc");
        tblreport.setUserAcc(userAcc);
        int i = tblreportService.addReportMsg(tblreport);
        return String.valueOf(i);
    }


}
