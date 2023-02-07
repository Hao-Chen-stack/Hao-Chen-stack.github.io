package com.cykj.service.impl;

import com.cykj.bean.Tblpower;
import com.cykj.bean.Tblrole;
import com.cykj.mapper.TblpowerMapper;
import com.cykj.service.TblpowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<Tblpower> findDistributedPowerByroleid(long roleid) {
        return tblpowerMapper.findDistributedPowerByroleid(roleid);
    }


    @Override
    public List<Tblpower> findUnDistributedPower(long roleid) {
        List<Tblpower> list = new ArrayList<>();
        List<Tblpower> childList = tblpowerMapper.findUnDistributedPower(roleid);
        if (childList.size() > 0) {
            List<Tblpower> parentList = tblpowerMapper.findUnDistributedPower_parent(childList);
            list.addAll(parentList);
        }
        list.addAll(childList);

        return list;
    }

    @Override
    public List<Tblpower> findUnDisPowerByRid(long roleid) {
        return tblpowerMapper.findUnDisPowerByRid(roleid);
    }

    @Override
    public int addAllDisPower(long roleid, List<Tblpower> powerid) {
        int i;
        if (powerid.size() > 0) {
            i = tblpowerMapper.addAllDisPower(roleid, powerid);
        } else {
            i = -1;
        }
        return i;
    }

    @Override
    public int cancelDisPowerAll(long roleid) {
        return tblpowerMapper.cancelDisPowerAll(roleid);
    }

    @Override
    public int addCheckUnDisPower(long roleid, int[] powerid) {
        int i;
        if (powerid!= null && powerid.length>0){
            i = tblpowerMapper.addCheckUnDisPower(roleid, powerid);
        }else {
            i= -1;
        }
        return i;
    }

    @Override
    public int cancelCheckDisPower(long roleid,int[] havepowerid) {
        int i;
        if (havepowerid != null && havepowerid.length>0){
            i = tblpowerMapper.cancelCheckDisPower(roleid,havepowerid);
        }else {
            i = -1;
        }
        return i;
    }


}
