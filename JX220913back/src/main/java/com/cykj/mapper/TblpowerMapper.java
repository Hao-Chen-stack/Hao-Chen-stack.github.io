package com.cykj.mapper;

import com.cykj.bean.Tblpower;
import com.cykj.bean.Tblrole;
import com.cykj.bean.Tblrolepower;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblpowerMapper {
    //查询系统中的角色列表
    List<Tblrole> findRoleList();

    //根据管理员账号查询已分配的权限列表并放置到菜单栏上
    List<Tblpower> findDistributedPower(@Param("managerAcc") String managerAcc);


    //根据角色id查询已分配的权限列表
    List<Tblpower> findDistributedPowerByroleid(@Param("roleid") long roleid);

    //根据角色id查询未分配的权限列表
    List<Tblpower> findUnDistributedPower(@Param("roleid") long roleid);
    List<Tblpower> findUnDistributedPower_parent(@Param("childList") List<Tblpower> childList);

    //从所有未分配的一级菜单包括子菜单分配给角色
    List<Tblpower> findUnDisPowerByRid(@Param("roleid") long roleid);
    int addAllDisPower(@Param("roleid") long roleid,
                       @Param("powerid") List<Tblpower> powerid);

    //将所有已分配一级菜单及子菜单取消
    int cancelDisPowerAll(@Param("roleid") long roleid);

    //从右侧选中子菜单分配给角色
    int addCheckUnDisPower(@Param("roleid") long roleid,
                           @Param("powerid") int[] powerid);

    // 将分配的子菜单取消
    int cancelCheckDisPower(@Param("roleid") long roleid,
                            @Param("havepowerid") int[] havepowerid);


}
