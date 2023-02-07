package com.cykj.service.impl;

import com.cykj.bean.Tblbill;
import com.cykj.mapper.TblbillMapper;
import com.cykj.service.TblbillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblbillServiceImpl implements TblbillService {
    @Autowired
    private TblbillMapper tblbillMapper;

    @Override
    public List<Tblbill> findBillListByManagerAcc(String managerAcc) {
        return tblbillMapper.findBillListByManagerAcc(managerAcc);
    }

    @Override
    public int addBillMsg(Tblbill tblbill) {
        return tblbillMapper.addBillMsg(tblbill);
    }
}
