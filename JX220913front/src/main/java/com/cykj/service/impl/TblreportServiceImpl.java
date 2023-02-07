package com.cykj.service.impl;


import com.cykj.bean.Tblreport;
import com.cykj.mapper.TblreportMapper;
import com.cykj.service.TblreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblreportServiceImpl implements TblreportService {
    @Autowired
    private TblreportMapper tblreportMapper;
    @Override
    public List<Tblreport> findReportListByUAcc(String userAcc, int page, int size) {
        return tblreportMapper.findReportListByUAcc(userAcc,page,size);
    }

    @Override
    public int findReportCount(String userAcc) {
        return tblreportMapper.findReportCount(userAcc);
    }

    @Override
    public List<Tblreport> findContextAndResByDate(long reportId) {
        return tblreportMapper.findContextAndResByDate(reportId);
    }

    @Override
    public int addReportMsg(Tblreport tblreport) {
        return tblreportMapper.addReportMsg(tblreport);
    }


}
