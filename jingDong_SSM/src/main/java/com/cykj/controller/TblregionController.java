package com.cykj.controller;


import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblregion;
import com.cykj.service.TblregionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/region",produces = "text/html;charset=utf-8")
public class TblregionController {

    @Autowired
    private TblregionService tblregionService;

    @RequestMapping("/ByParentId")
    @ResponseBody
    public String findRegionListByParentId(@RequestParam("parentId") long parentId){
        List<Tblregion> list = tblregionService.findRegionByParentId(parentId);

        String json = JSON.toJSONString(list);
        return json;
    }

    @RequestMapping("/list")
    @ResponseBody
    public String findRegionList(
            @RequestParam("province") long provinceId,
            @RequestParam("city") long cityId,
            @RequestParam("area") String areaName,
            @RequestParam("regionStatus") long regionStatus,
            @RequestParam("page") int page,
            @RequestParam("size") int size){

        int index = (page-1)*size;
        List<Tblregion> regionList = tblregionService.findRegionList(provinceId,cityId,areaName,regionStatus,index,size);
        int counts = tblregionService.findRegionCount(provinceId,cityId,areaName,regionStatus);

        Map<String,Object> map = new HashMap();
        map.put("data",regionList);
        map.put("counts",counts);

        String json = JSON.toJSONString(map);
        return json;
    }

    @RequestMapping("/addRegion")
    @ResponseBody
    public String addRegion(@RequestParam("regionName") String regionName,
                            @RequestParam("parentId") String parentId){
        Tblregion tblregion = new Tblregion();
        tblregion.setRegionName(regionName);
        tblregion.setParentId(parentId);

        int i = tblregionService.addRegion(tblregion);

        String json = JSON.toJSONString(i);
        return json;
    }

    @RequestMapping("/deleteRegionRow")
    @ResponseBody
    public String deleteRegionRow(@RequestParam("Rid") int rid){
        int delRegion = tblregionService.delRegion(rid);
        int i = Integer.parseInt(JSON.toJSONString(delRegion));

        String json = JSON.toJSONString(i);
        return json;
    }

    @RequestMapping("/updateArea")
    @ResponseBody
    public String updateArea(@RequestParam("regionId") long regionId,
                             @RequestParam("area") String areaName){
        Tblregion tblregion = new Tblregion();
        tblregion.setRegionName(areaName);
        tblregion.setRegionId(regionId);

        int i = tblregionService.updateRegion(tblregion);
        String json = JSON.toJSONString(i);
        return json;
    }


}
