package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.ruankun.laughingspork.entity.SxCorporation;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;
import xyz.ruankun.laughingspork.service.SxCorporationService;
import xyz.ruankun.laughingspork.repository.SxCorporationRepository;
import xyz.ruankun.laughingspork.service.SxStudentService;

@Service
public class SxCorporationServiceImpl implements SxCorporationService {

    @Autowired
    private SxCorporationRepository resp;

    @Autowired
    private SxStudentRepository sxStudentRepository;

    @Override
    @Transactional
    public void save(SxCorporation sxCorporation) {
        SxStudent sxStudent = sxStudentRepository.findByStuNo(sxCorporation.getStuNo());
        sxStudent.setCorpName(sxCorporation.getCorpName());
        sxStudent.setCorpRegCode(sxCorporation.getRegCode());
        sxStudent.setCorpTaxcode(sxCorporation.getCreditCode());
        resp.deleteAllByStuNo(sxCorporation.getStuNo());
        sxStudentRepository.saveAndFlush(sxStudent);
        resp.saveAndFlush(sxCorporation);
    }

    @Override
    public void delete(SxCorporation sxCorporation) {
        resp.deleteById(sxCorporation.getId());
    }

    @Override
    public SxCorporation findByStuNo(String stuNo) {
        return resp.findByStuNo(stuNo);
    }
}
