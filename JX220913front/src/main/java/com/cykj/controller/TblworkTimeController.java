package com.cykj.controller;

import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblworktime;
import com.cykj.service.TblworkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/workTime",produces = "text/html;charset=utf-8")
public class TblworkTimeController {
    @Autowired
    private TblworkTimeService tblworkTimeService;

    @RequestMapping("/workTimeMsg")
    @ResponseBody
    public String workTimeMsg(String managerAcc,String workDate){
        List<Tblworktime> workTimeMsg = tblworkTimeService.findWorkTimeMsg(managerAcc,workDate);
        int workTimeMsgCount = tblworkTimeService.findWorkTimeMsgCount(managerAcc, workDate);

        Map<String,Object> map = new HashMap<>();
        map.put("workTimeMsg",workTimeMsg);
        map.put("counts",workTimeMsgCount);
        return JSON.toJSONString(map);
    }

}
