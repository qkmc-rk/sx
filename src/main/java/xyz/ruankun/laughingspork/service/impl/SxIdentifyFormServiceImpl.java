package xyz.ruankun.laughingspork.service.impl;

import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;
import xyz.ruankun.laughingspork.service.SxIdentifyFormService;
import xyz.ruankun.laughingspork.repository.SxIdentifyFormRepository;

@Service
public class SxIdentifyFormServiceImpl implements SxIdentifyFormService {
    @Autowired
    private SxIdentifyFormRepository sxIdentifyFormRepository;

    @Autowired
    SxStudentRepository sxStudentRepository;

    public static final Logger log = LoggerFactory.getLogger(SxIdentifyFormService.class);

    @Override
    public SxIdentifyForm getIdentifyInfo(String stuNo) {
        SxIdentifyForm sxIdentifyFormOptional = sxIdentifyFormRepository.findByStuNo(stuNo);
        if (sxIdentifyFormOptional == null) {
            return null;
        }
        return sxIdentifyFormOptional;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SxIdentifyForm saveIdentifyForm(SxIdentifyForm sxIdentifyForm) {
        SxIdentifyForm newIdentifyForm = sxIdentifyFormRepository.save(sxIdentifyForm);
        // 更新filled flag 学生填写状态
        SxStudent sxStudent = sxStudentRepository.findByStuNo(newIdentifyForm.getStuNo());

        int identifyFilled = 0;
        if (!StringUtils.isEmpty(newIdentifyForm.getSxContent())) {
            identifyFilled++;
        }
        if (!StringUtils.isEmpty(newIdentifyForm.getSelfSummary())) {
            identifyFilled++;
        }

        // 更新flag 教师填写状态
        int identifyFlag = 0;

        if (!StringUtils.isEmpty(sxIdentifyForm.getCorpTeacherOpinion())) identifyFlag++;
        if (!StringUtils.isEmpty(sxIdentifyForm.getCorpOpinion())) identifyFlag++;
        if (!StringUtils.isEmpty(sxIdentifyForm.getCorpTeacherGrade())) identifyFlag++;
        if (!StringUtils.isEmpty(sxIdentifyForm.getTeacherGrade())) identifyFlag++;
        if (!StringUtils.isEmpty(sxIdentifyForm.getCollegePrincipalOpinion())) identifyFlag++;
        if (identifyFlag > 4) {
            // 五个都不为空 则已填完
            identifyFlag = 2;
        } else if (identifyFlag > 0) {
            // 部分不为空 未填完整
            identifyFlag = 1;
        }


        sxStudent.setIdentifyFilledFlag(identifyFilled);
        sxStudent.setIdentifyFlag(identifyFlag);
        sxStudentRepository.save(sxStudent);
        return newIdentifyForm;
    }

}
