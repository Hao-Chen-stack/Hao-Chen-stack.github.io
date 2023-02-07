package com.cykj.controller;

import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tbluser;
import com.cykj.service.TbluserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "user",produces = "text/html;charset=utf-8")
public class TbluserController {

    @Autowired
    private TbluserService tbluserService;

    @RequestMapping("list")
    @ResponseBody
    public String findUserList(Tbluser tbluser,int page, int size){
        page = (page-1)*size;
        
        List<Tbluser> userList = tbluserService.findUserList(tbluser, page, size);
        int counts = tbluserService.findUserCount(tbluser);

        Map<String,Object> map = new HashMap<>();
        map.put("data",userList);
        map.put("counts",counts);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/updateDelUser")
    @ResponseBody
    public String updateDelUser(long userId){
        int i = tbluserService.updateDelUser(userId);
        return String.valueOf(i);
    }

    @RequestMapping("/RePwd")
    @ResponseBody
    public String rePwd(long userId){
        int i = tbluserService.rePwd(userId);
        return String.valueOf(i);
    }

    @RequestMapping("onAndOffUser")
    @ResponseBody
    public String onAndOffUser(long userId,long userState){
        int i = tbluserService.onAndOffUser(userId,userState);
        return String.valueOf(i);
    }

    @RequestMapping("updateUBalanceByUId")
    @ResponseBody
    public String updateUBalanceByUId(String managerAcc,long userId){
        int i = tbluserService.updateUBalanceByUId(managerAcc, userId);
        return String.valueOf(i);
    }

}
