package com.cykj.service.impl;

import com.cykj.bean.Tblarea;
import com.cykj.mapper.TblareaMapper;
import com.cykj.service.TblareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblareaServiceImpl implements TblareaService {
    @Autowired
    private TblareaMapper tblareaMapper;

    @Override
    public List<Tblarea> findAreaNameByMAcc(String managerAcc) {
        return tblareaMapper.findAreaNameByMAcc(managerAcc);
    }
}
