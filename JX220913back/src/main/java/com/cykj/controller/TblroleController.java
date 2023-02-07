package com.cykj.controller;

import com.alibaba.fastjson.JSON;
import com.cykj.service.TblroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "role",produces = "text/html;charset=utf-8")
public class TblroleController {

    @Autowired
    private TblroleService tblroleService;

    @RequestMapping("/roleName")
    @ResponseBody
    public String findRoleNameByAcc(String managerAcc){
        String roleName = tblroleService.findRoleNameByAcc(managerAcc);
        return JSON.toJSONString(roleName);
    }
}
