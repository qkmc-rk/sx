package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.entity.SxTeacher;
import xyz.ruankun.laughingspork.repository.SxIdentifyFormRepository;
import xyz.ruankun.laughingspork.service.SxTeacherService;
import xyz.ruankun.laughingspork.repository.SxTeacherRepository;

@Service
public class SxTeacherServiceImpl implements SxTeacherService {
    @Autowired
    private SxTeacherRepository resp;
    @Autowired
    private SxIdentifyFormRepository sxIdentifyFormRepository;

    @Override
    public SxTeacher getByTeacherNo(String teacherNo) {
        return resp.findByTeacherNo(teacherNo);
    }

    @Override
    public void save(SxTeacher sxTeacher) {
        resp.save(sxTeacher);
    }

    @Override
    public SxIdentifyForm fillIndentifyAdvice(SxStudent sxStudent, String CTOpnion, String CTScore) {
        SxIdentifyForm sxIdentifyForm = sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
//        sxIdentifyForm.setCTOption(CTOpnion);表中没有校内指导老师意见
        sxIdentifyForm.setTeacherGrade(CTScore);
        return sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
    }

    @Override
    public SxTeacher findByTeacherNo(String teacherNo) {
        return resp.findByTeacherNo(teacherNo);
    }
}
