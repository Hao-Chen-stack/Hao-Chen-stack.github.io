package com.cykj.controller;


import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblbill;
import com.cykj.bean.Tblmanager;
import com.cykj.service.TblbillService;
import com.cykj.service.TblmanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "bill",produces = "text/html;charset=utf-8")
public class TblbillController {

    @Autowired
    private TblbillService tblbillService;
    @Autowired
    private TblmanagerService tblmanagerService;

    @RequestMapping("findBillList")
    @ResponseBody
    public String findBillListByManagerAcc(HttpSession session){
        Tblmanager manager = (Tblmanager) session.getAttribute("admin");
        String managerBalance = tblmanagerService.findmanagerBalanceByAcc(manager.getManagerAcc());
        List<Tblbill> billList = tblbillService.findBillListByManagerAcc(manager.getManagerAcc());

        Map<String,Object> map = new HashMap<>();
        map.put("managerBalance",managerBalance);
        map.put("billList",billList);

        return JSON.toJSONString(map);
    }

    @RequestMapping("/addBillMsg")
    @ResponseBody
    public String addBillMsg(Tblbill tblbill,String managerAcc){
        double priceByAcc = tblmanagerService.findPriceByAcc(managerAcc);
        long idByAcc = tblmanagerService.findIdByAcc(managerAcc);
        tblbill.setManagerId(idByAcc);
        tblbill.setAmount(priceByAcc);
        int i = tblbillService.addBillMsg(tblbill);

        return String.valueOf(i);
    }
}
