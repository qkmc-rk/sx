package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxCollegePrincipal;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.repository.SxIdentifyFormRepository;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;
import xyz.ruankun.laughingspork.service.SxCollegePrincipalService;
import xyz.ruankun.laughingspork.repository.SxCollegePrincipalRepository;
import xyz.ruankun.laughingspork.util.DateUtil;

import java.util.List;

@Service
public class SxCollegePrincipalServiceImpl implements SxCollegePrincipalService {
    @Autowired
    private SxCollegePrincipalRepository resp;
    @Autowired
    private SxStudentRepository sxStudentRepository;
    @Autowired
    private SxIdentifyFormRepository sxIdentifyFormRepository;

    @Override
    public List<SxStudent> getOwnedStudentsList(SxCollegePrincipal sxCollegePrincipal) {
        return sxStudentRepository.findByCollege(sxCollegePrincipal.getCollege());
    }

    @Override
    public SxIdentifyForm getIdentifyFormByStuId(String stuNo) {
        return sxIdentifyFormRepository.findByStuNo(stuNo);
    }

    @Override
    public SxIdentifyForm operateIdentifyForm(String stuNo, String collegePrincipalOpinion, String comprehsvGrade) {
        SxIdentifyForm oldForm = sxIdentifyFormRepository.findByStuNo(stuNo);
        oldForm.setCollegePrincipalOpinion(collegePrincipalOpinion);
        oldForm.setCPODate(DateUtil.getSqlDate());
        oldForm.setComprehsvGrade(comprehsvGrade);
        oldForm.setCGDate(DateUtil.getSqlDate());
        sxIdentifyFormRepository.save(oldForm);
        return sxIdentifyFormRepository.findByStuNo(stuNo);
    }

    @Override
    public SxCollegePrincipal findByAccount(String account) {
        return resp.findByAccount(account);
    }

    @Override
    public void save(SxCollegePrincipal sxCollegePrincipal) {
        resp.save(sxCollegePrincipal);
    }
}
