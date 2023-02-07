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
    public String distributedPower(@RequestParam("roleId") long roleId){
        List<Tblpower> distributedPower = tblpowerService.findDistributedPower(roleId);
        List<Tblpower> unDistributedPower = tblpowerService.findUnDistributedPower(roleId);

        Map<String,Object> map = new HashMap<>();
        map.put("haveList",distributedPower);
        map.put("unHaveList",unDistributedPower);
        return JSON.toJSONString(map);

    }

    @RequestMapping("/deleteByRoleId")
    @ResponseBody
    public String deleteByRoleId(long roleId){
        int i = tblpowerService.delPowerByRoleId(roleId);
        return String.valueOf(i);

    }
}
