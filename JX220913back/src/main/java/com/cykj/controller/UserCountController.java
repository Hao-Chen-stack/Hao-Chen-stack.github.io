package com.cykj.controller;


import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tbluser;
import com.cykj.service.UserCountService;
import com.cykj.utils.YearUtis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/userCount",produces = "text/html;charset=utf-8")
public class UserCountController {
    @Autowired
    private UserCountService userCountService;

    @RequestMapping("/findWeekNowList")
    @ResponseBody
    public String findWeekNowList(Tbluser tbluser){
        List<Tbluser> weekNowList = userCountService.findWeekNowList(tbluser);
        return JSON.toJSONString(weekNowList);
    }

    @RequestMapping("/findMonthNowList")
    @ResponseBody
    public String findMonthNowList(Tbluser tbluser){
        List<Tbluser> MonthNowList = userCountService.findMonthNowList(tbluser);
        return JSON.toJSONString(MonthNowList);
    }

    @RequestMapping("/findHalfYearNowList")
    @ResponseBody
    public String findHalfYearNowList(String singleYearMonth){
        List<String> yearMonths = YearUtis.halfYear();
        List<Tbluser> halfYearNowList = userCountService.findHalfYearNowList(yearMonths);
        return JSON.toJSONString(halfYearNowList);
    }




}
