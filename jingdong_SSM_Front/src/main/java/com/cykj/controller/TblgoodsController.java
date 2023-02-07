package com.cykj.controller;

import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblgoods;
import com.cykj.bean.Tblgoodtype;
import com.cykj.service.TblgoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/goods",produces = "text/html;charset=utf-8")
public class TblgoodsController {
    @Autowired
    private TblgoodsService tblgoodsService;

    @RequestMapping("/list")
    @ResponseBody
    public String findGoodsList(){
        List<Tblgoods> goodsList = tblgoodsService.findGoodsList();
        return JSON.toJSONString(goodsList);
    }


}
