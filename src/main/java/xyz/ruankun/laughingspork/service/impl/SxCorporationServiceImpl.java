package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.ruankun.laughingspork.entity.SxCorporation;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.service.SxCorporationService;
import xyz.ruankun.laughingspork.repository.SxCorporationRepository;
import xyz.ruankun.laughingspork.service.SxStudentService;

@Service
public class SxCorporationServiceImpl implements SxCorporationService {
    @Autowired
    private SxCorporationRepository resp;

    @Autowired
    private SxStudentService sxStudentService;

    @Override
    @Transactional
    public void save(SxCorporation sxCorporation) {
        SxStudent sxStudent = sxStudentService.findByStuNo(sxCorporation.getStuNo());
        sxStudent.setCorpName(sxCorporation.getCorpName());
        sxStudent.setCorpRegCode(sxCorporation.getRegCode());
        sxStudent.setCorpTaxcode(sxCorporation.getCreditCode());
        resp.save(sxCorporation);
    }

    @Override
    public SxCorporation findByStuNo(String stuNo) {
        return resp.findByStuNo(stuNo);
    }
}
