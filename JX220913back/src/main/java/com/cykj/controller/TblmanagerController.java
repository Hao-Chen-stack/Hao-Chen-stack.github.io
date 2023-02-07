package com.cykj.controller;


import com.alibaba.fastjson.JSON;
import com.cykj.bean.Tblmanager;
import com.cykj.bean.Tblpower;

import com.cykj.mapper.TblareaMapper;
import com.cykj.mapper.TblpowerMapper;
import com.cykj.mapper.TblroleMapper;
import com.cykj.service.TblmanagerService;

import com.cykj.utils.BuildTree;
import com.cykj.utils.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/manager",produces = "text/html;charset=utf-8")
public class TblmanagerController {

    @Autowired
    private TblmanagerService tblmanagerService;
    @Autowired
    private TblpowerMapper tblpowerMapper;
    @Autowired
    private TblroleMapper tblroleMapper;


    @RequestMapping("/findManager")
    @ResponseBody
    public String findManager(String managerAcc, String managerPwd, String Code, HttpSession session){
        //获取管理员昵称和角色名称
        String managerName = tblmanagerService.findRealNameByAcc(managerAcc);
        String roleName = tblroleMapper.findRoleNameByAcc(managerAcc);

        List<Tblpower> list = tblpowerMapper.findDistributedPower(managerAcc);

        List<TreeVo<Tblpower>> trees = new ArrayList<TreeVo<Tblpower>>();
        for (Tblpower power : list) {
            //循环遍历
            //定义一个数据节点类
            TreeVo<Tblpower> vo = new TreeVo<>();
            //赋值
            vo.setId(power.getpowerid()+ "");
            vo.setText(power.getPowerName());//节点名称
            vo.setParentId(power.getParentId() + "");
            vo.setPowerUrl(power.getPowerUrl());
            trees.add(vo);
        }
//        System.out.println("-----------"+trees);
        List<TreeVo<Tblpower>> treeVos = BuildTree.buildList(trees, "0");

//        System.out.println(treeVos);
        System.out.println("输入的验证码为"+Code);
        System.out.println("正确的验证码："+(session.getAttribute("strCode")));
        int i;
        if ((session.getAttribute("strCode")).equals(Code)){
            i = tblmanagerService.findManager(managerAcc, managerPwd);

            long managerId = tblmanagerService.findIdByAcc(managerAcc);
            Tblmanager manager = new Tblmanager();
            manager.setManagerAcc(managerAcc);
            manager.setManagerPwd(managerPwd);
            manager.setManagerId(managerId);

            session.setAttribute("admin",manager);
        }else {
            i = 2;
        }

        Map<String,Object> map = new HashMap<>();
        map.put("manager",i);
        map.put("treeVos",treeVos);
        map.put("managerName",managerName);
        map.put("roleName",roleName);

        return JSON.toJSONString(map);
    }

    @RequestMapping("/findManagerList")
    @ResponseBody
    public String findManagerList(Tblmanager tblmanager, int page, int size){
        page = (page-1)*size;

        List<Tblmanager> managerList = tblmanagerService.findManagerList(tblmanager, page, size);
        int counts = tblmanagerService.findManagerCount(tblmanager);

        Map<String,Object> map = new HashMap<>();
        map.put("data",managerList);
        map.put("counts",counts);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/updateDelManager")
    @ResponseBody
    public String updateDelManager(long managerId){
        int i = tblmanagerService.updateDelManager(managerId);
        return String.valueOf(i);
    }

    @RequestMapping("/managerRePwd")
    @ResponseBody
    public String rePwd(long managerId){
        int i = tblmanagerService.rePwd(managerId);
        return String.valueOf(i);
    }

    @RequestMapping("onAndOffManager")
    @ResponseBody
    public String onAndOffManager(long managerId,long managerStatus){
        int i = tblmanagerService.onAndOffManager(managerId,managerStatus);
        return String.valueOf(i);
    }

    @RequestMapping("/addManager")
    @ResponseBody
    public String addManager(Tblmanager tblmanager,String managerAcc,String[] areaName){

        int i;
        int j = tblmanagerService.findAcc(managerAcc);
        if (j==0){
            i = tblmanagerService.addManager(tblmanager,areaName);
        }else {
            i =2;
        }
        return JSON.toJSONString(i);
    }

    @RequestMapping("/updateMBalanceByMAcc")
    @ResponseBody
    public String updateMBalanceByMAcc(String managerAcc){
        int i = tblmanagerService.updateMBalanceByMAcc(managerAcc);
        return JSON.toJSONString(i);
    }

    @RequestMapping("/findRoleIdByMAcc")
    @ResponseBody
    public String findRoleIdByMAcc(String managerAcc,HttpSession session){
        Tblmanager tblmanager = (Tblmanager) session.getAttribute("admin");
        managerAcc = tblmanager.getManagerAcc();
        int roleIdByMAcc = tblmanagerService.findRoleIdByMAcc(managerAcc);
        return JSON.toJSONString(roleIdByMAcc);
    }

}
