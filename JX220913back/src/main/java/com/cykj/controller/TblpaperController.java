package com.cykj.controller;


import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblappointment;
import com.cykj.bean.Tblmanager;
import com.cykj.bean.Tblpaper;
import com.cykj.service.TblpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    public String findPaperByAreaName(String areaName,int page, int size){
        page = (page-1)*size;

        List<Tblpaper> paperByAreaNameList = tblpaperService.findPaperByAreaName(areaName, page, size);
        int paperByAreaNameCount = tblpaperService.findPaperByAreaNameCount(areaName);

        Map<String,Object> map = new HashMap<>();
        map.put("data",paperByAreaNameList);
        map.put("counts",paperByAreaNameCount);
        return JSON.toJSONString(map);

    }

    @RequestMapping("/addPaperMsg")
    @ResponseBody
    public String addPaperMsg(Tblpaper tblpaper){
        int i;
        if (tblpaper.getAreaName() != null&& !tblpaper.getAreaName().equals("")){
            i = tblpaperService.addPaperMsg(tblpaper);
        }else {
            i = 2;
        }
        return String.valueOf(i);

    }

    @RequestMapping("/updatePaperMsg")
    @ResponseBody
    public String updatePaperMsg(Tblpaper tblpaper){
        int i;
        if (tblpaper.getAreaName() != null&& !tblpaper.getAreaName().equals("")){
            i = tblpaperService.updatePaperMsg(tblpaper);
        }else {
            i = 2;
        }
        return String.valueOf(i);
    }

    @RequestMapping("/delPaperMsgByPId")
    @ResponseBody
    public String delPaperMsgByPId(long paperId){
        int i = tblpaperService.delPaperMsgByPId(paperId);
        return String.valueOf(i);
    }

    @RequestMapping("/findPaperMsgById")
    @ResponseBody
    public String findPaperMsgById(long paperId){
        List<Tblpaper> paperMsgByIdList = tblpaperService.findPaperMsgById(paperId);
        return JSON.toJSONString(paperMsgByIdList);
    }


}
