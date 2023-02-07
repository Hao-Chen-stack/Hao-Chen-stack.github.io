package com.cykj.controller;


import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblevaluate;
import com.cykj.bean.Tblmanager;
import com.cykj.service.TblevaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/evaluate",produces = "text/html;charset=utf-8")
public class TblevaluateController {
    @Autowired
    private TblevaluateService tblevaluateService;

    @RequestMapping("/findEvaListByMAcc")
    @ResponseBody
    public String findEvaListByMAcc(String managerAcc,long userId,HttpSession session){
        Tblmanager tblmanager = (Tblmanager) session.getAttribute("admin");
        String sessionManagerAcc = tblmanager.getManagerAcc();

        List<Tblevaluate> evaListByMAcc;
        if (managerAcc.equals(sessionManagerAcc)){
            evaListByMAcc = tblevaluateService.findEvaListByMAcc(sessionManagerAcc,userId);
        }else {
            evaListByMAcc = tblevaluateService.findEvaListByMAcc(managerAcc,userId);
        }
        return JSON.toJSONString(evaListByMAcc);
    }

}
