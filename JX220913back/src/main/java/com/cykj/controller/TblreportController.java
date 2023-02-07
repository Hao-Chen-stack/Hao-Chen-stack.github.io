package com.cykj.controller;

import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblappointment;
import com.cykj.bean.Tblmanager;
import com.cykj.bean.Tblreport;
import com.cykj.service.TblreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/report",produces = "text/html;charset=utf-8")
public class TblreportController {
    @Autowired
    private TblreportService tblreportService;

    @RequestMapping("/findReportListBySomeCondition")
    @ResponseBody
    public String findReportListBySomeCondition(Tblreport tblreport, int page, int size){
        page = (page-1)*size;
        List<Tblreport> reportListBySomeCondition = tblreportService.findReportListBySomeCondition(tblreport, page, size);
        int reportCounts = tblreportService.findReportCountBySomeCondition(tblreport);

        Map<String,Object> map = new HashMap<>();
        map.put("data",reportListBySomeCondition);
        map.put("counts",reportCounts);
        return JSON.toJSONString(map);

    }

    @RequestMapping("/findContextAndResByRId")
    @ResponseBody
    public String findContextAndResByRId(long reportId){
        List<Tblreport> ContextAndResByRIdList = tblreportService.findContextAndResByRId(reportId);
        return JSON.toJSONString(ContextAndResByRIdList);
    }
}
