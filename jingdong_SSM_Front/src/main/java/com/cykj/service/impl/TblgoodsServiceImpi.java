package com.cykj.service.impl;

import com.cykj.bean.Tblgoods;
import com.cykj.mapper.TblgoodsMapper;
import com.cykj.service.TblgoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TblgoodsServiceImpi implements TblgoodsService {
   @Autowired
   private TblgoodsMapper tblgoodsMapper;

    @Override
    public List<Tblgoods> findGoodsList() {
        return tblgoodsMapper.findGoodsList();
    }
}
