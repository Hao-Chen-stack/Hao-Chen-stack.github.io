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
    public List<Tblreport> findReportListBySomeCondition(Tblreport tblreport, int page, int size) {
        return tblreportMapper.findReportListBySomeCondition(tblreport, page, size);
    }

    @Override
    public int findReportCountBySomeCondition(Tblreport tblreport) {
        return tblreportMapper.findReportCountBySomeCondition(tblreport);
    }

    @Override
    public List<Tblreport> findContextAndResByRId(long reportId) {
        return tblreportMapper.findContextAndResByRId(reportId);
    }
}
