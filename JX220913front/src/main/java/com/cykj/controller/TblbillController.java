package com.cykj.controller;


import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblappointment;
import com.cykj.bean.Tblbill;
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
@RequestMapping(value = "/bill",produces = "text/html;charset=utf-8")
public class TblbillController {
    @Autowired
    private TblbillService tblbillService;
    @Autowired
    private TblmanagerService tblmanagerService;


    @RequestMapping("/findBillListByUAcc")
    @ResponseBody
    public String findBillListByUAcc(String userAcc,int page, int size,HttpSession session){
        page = (page-1)*size;

        userAcc= (String) session.getAttribute("userAcc");
        List<Tblbill> billListByUAcc = tblbillService.findBillListByUAcc(userAcc,page,size);
        int billListByUAccCount = tblbillService.findBillListByUAccCount(userAcc);
        String userBalanceByUAcc = tblbillService.findUserBalanceByUAcc(userAcc);

        Map<String,Object> map = new HashMap<>();
        map.put("billList",billListByUAcc);
        map.put("userBalance",userBalanceByUAcc);
        map.put("counts",billListByUAccCount);
        return JSON.toJSONString(map);

    }

    @RequestMapping("/addBillMsg")
    @ResponseBody
    public String addBillMsg(Tblbill tblbill,HttpSession session){
        tblbill.setUserAcc((String) session.getAttribute("userAcc"));
        int i = tblbillService.addBillMsg(tblbill);
        return String.valueOf(i);
    }



}
