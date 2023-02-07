package com.cykj.controller;

import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblpaper;
import com.cykj.service.TblpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/tblPaper",produces = "text/html;charset=utf-8")
public class TblpaperController {
    @Autowired
    private TblpaperService tblpaperService;

    @RequestMapping("/findPaperByAreaName")
    @ResponseBody
    public String findPaperByAreaName(String areaName){
        List<Tblpaper> paperByAreaNameList = tblpaperService.findPaperByAreaName(areaName);
        return JSON.toJSONString(paperByAreaNameList);
    }
}
