package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.entity.SxTeacher;
import xyz.ruankun.laughingspork.repository.SxIdentifyFormRepository;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;
import xyz.ruankun.laughingspork.service.SxTeacherService;
import xyz.ruankun.laughingspork.repository.SxTeacherRepository;

import java.util.List;

@Service
public class SxTeacherServiceImpl implements SxTeacherService {
    @Autowired
    private SxTeacherRepository resp;
    @Autowired
    private SxIdentifyFormRepository sxIdentifyFormRepository;
    @Autowired
    private SxStudentRepository sxStudentRepository;

    @Override
    public List<SxStudent> getStudentListByTeacherNo(SxTeacher sxTeacher) {
        return sxStudentRepository.findByTeacherNo(sxTeacher.getTeacherNo());
    }

    @Override
    public void save(SxTeacher sxTeacher) {
        resp.save(sxTeacher);
    }

    @Override
    public SxIdentifyForm fillIndentifyAdvice(String stuNo, String opinion, String score) {
        SxIdentifyForm sxIdentifyForm = sxIdentifyFormRepository.findByStuNo(stuNo);
//        sxIdentifyForm.setCTOption(CTOpnion);表中没有校内指导老师意见，随便找了个字段（SelfSummary）存
        sxIdentifyForm.setSelfSummary(opinion);
        sxIdentifyForm.setTeacherGrade(score);
        sxIdentifyFormRepository.save(sxIdentifyForm);
        return sxIdentifyFormRepository.findByStuNo(stuNo);
    }

    @Override
    public SxTeacher findByTeacherNo(String teacherNo) {
        return resp.findByTeacherNo(teacherNo);
    }
}
