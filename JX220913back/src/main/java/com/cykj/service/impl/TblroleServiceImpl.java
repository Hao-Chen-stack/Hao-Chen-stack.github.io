package com.cykj.service.impl;

import com.cykj.mapper.TblroleMapper;
import com.cykj.service.TblroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TblroleServiceImpl implements TblroleService {
    @Autowired
    private TblroleMapper tblroleMapper;
    @Override
    public String findRoleNameByAcc(String managerAcc) {
        return tblroleMapper.findRoleNameByAcc(managerAcc);
    }
}
