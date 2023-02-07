package com.cykj.service;

import com.cykj.bean.Tblpower;
import com.cykj.bean.Tblrole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblpowerService {
    //查询系统中的角色列表
    List<Tblrole> findRoleList();

    //根据角色id查询已分配的权限列表
    List<Tblpower> findDistributedPowerByroleid(long roleid);

    //根据角色id查询未分配的权限列表
    List<Tblpower> findUnDistributedPower(long roleid);

    //从所有未分配的一级菜单包括子菜单分配给角色
    List<Tblpower> findUnDisPowerByRid(long roleid);
    int addAllDisPower(long roleid,  List<Tblpower> powerid);

    //将所有已分配一级菜单及子菜单取消
    int cancelDisPowerAll(long roleid);

    //从右侧选中子菜单分配给角色
    int addCheckUnDisPower(long roleid,int[] checkList);

    // 将分配的子菜单取消
    int cancelCheckDisPower(long roleid,int[] havepowerid);

}
