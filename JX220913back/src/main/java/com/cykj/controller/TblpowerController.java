package com.cykj.controller;

import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblpower;
import com.cykj.bean.Tblrole;
import com.cykj.service.TblpowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/power",produces = "text/html;charset=utf-8")
public class TblpowerController {
    @Autowired
    private TblpowerService tblpowerService;

    @RequestMapping("/roleList")
    @ResponseBody
    public String roleList(){
        List<Tblrole> roleList = tblpowerService.findRoleList();
        return JSON.toJSONString(roleList);

    }

    @RequestMapping("/powerList")
    @ResponseBody
    public String distributedPower(long roleid){
        List<Tblpower> distributedPower = tblpowerService.findDistributedPowerByroleid(roleid);
        List<Tblpower> unDistributedPower = tblpowerService.findUnDistributedPower(roleid);

        Map<String,Object> map = new HashMap<>();
        map.put("haveList",distributedPower);
        map.put("unHaveList",unDistributedPower);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/addAllDisPower")
    @ResponseBody
    public String addAllDisPower(long roleid){
        List<Tblpower> unDisPowerByRid = tblpowerService.findUnDisPowerByRid(roleid);
        int i = tblpowerService.addAllDisPower(roleid, unDisPowerByRid);
        return String.valueOf(i);
    }

    @RequestMapping("/cancelDisPowerAll")
    @ResponseBody
    public String cancelDisPowerAll(long roleid){
        int i = tblpowerService.cancelDisPowerAll(roleid);
        return String.valueOf(i);
    }

    @RequestMapping("/addCheckUnDisPower")
    @ResponseBody
    public String addCheckUnDisPower(long roleid,int[] powerid){
        int i = tblpowerService.addCheckUnDisPower(roleid, powerid);
        return String.valueOf(i);
    }

    @RequestMapping("/cancelCheckDisPower")
    @ResponseBody
    public String cancelCheckDisPower(long roleid,int[] havepowerid){
        int i = tblpowerService.cancelCheckDisPower(roleid, havepowerid);
        return String.valueOf(i);
    }




}
