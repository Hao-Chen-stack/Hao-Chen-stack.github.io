package com.cykj.service.impl;

import com.cykj.bean.Tblpower;
import com.cykj.bean.Tblrole;
import com.cykj.mapper.TblpowerMapper;
import com.cykj.service.TblpowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TblpowerServiceImpl implements TblpowerService {
    @Autowired
    private TblpowerMapper tblpowerMapper;

    @Override
    public List<Tblrole> findRoleList() {
        return tblpowerMapper.findRoleList();
    }

    @Override
    public List<Tblpower> findDistributedPower(long roleId) {
        return tblpowerMapper.findDistributedPower(roleId);
    }

    @Override
    public List<Tblpower> findUnDistributedPower(long roleId) {
        List<Tblpower> childList = tblpowerMapper.findUnDistributedPower(roleId);
        List<Tblpower> parentList = tblpowerMapper.findUnDistributedPower_parent(childList);
        List<Tblpower> list = new ArrayList<>();
        list.addAll(childList);
        list.addAll(parentList);
        return list;

    }

    @Override
    public int delPowerByRoleId(long roleId) {
        return tblpowerMapper.delPowerByRoleId(roleId);
    }
}
