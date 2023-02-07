package com.cykj.service.impl;

import com.cykj.bean.Tblgoods;
import com.cykj.bean.Tblgoodtype;
import com.cykj.bean.Tblrole;
import com.cykj.mapper.TblgoodsMapper;
import com.cykj.service.TblgoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblgoodsServiceImpl implements TblgoodsService {
    @Autowired
    private TblgoodsMapper tblgoodsMapper;


//    @Override
//    public List<Tblgoods> findGoodsList(int index, int size) {
//        return tblgoodsMapper.findGoodsList(index,size);
//    }

    @Override
    public List<Tblgoods> findGoodsList(Tblgoods tblgoods,int page, int size) {
        return tblgoodsMapper.findGoodsList(tblgoods,page,size);
    }

    @Override
    public int findGoodsCount(Tblgoods tblgoods) {
        return tblgoodsMapper.findGoodsCount(tblgoods);
    }

    @Override
    public int delGoodsByGoodsId(long goodsId) {
        return tblgoodsMapper.delGoodsByGoodsId(goodsId);
    }

    @Override
    public int addGoods(Tblgoods tblgoods) {
        return tblgoodsMapper.addGoods(tblgoods);
    }

    @Override
    public int updateGoods(Tblgoods tblgoods) {
        return tblgoodsMapper.updateGoods(tblgoods);
    }

    @Override
    public List<Tblgoodtype> findGoodsTypeList() {
        return tblgoodsMapper.findGoodsTypeList();
    }


}
