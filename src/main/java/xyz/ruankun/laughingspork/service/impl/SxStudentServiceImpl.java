package xyz.ruankun.laughingspork.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.entity.SxTeacher;
import xyz.ruankun.laughingspork.repository.SxIdentifyFormRepository;
import xyz.ruankun.laughingspork.repository.SxReportRepository;
import xyz.ruankun.laughingspork.repository.SxTeacherRepository;
import xyz.ruankun.laughingspork.service.SxStudentService;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;


@Service
public class SxStudentServiceImpl implements SxStudentService {

    @Autowired
    private SxStudentRepository resp;

    @Autowired
    private SxReportRepository sxReportRepository;

    @Autowired
    private SxIdentifyFormRepository sxIdentifyFormRepository;

    @Autowired
    private SxTeacherRepository sxTeacherRepository;

    public static final Logger logger = LoggerFactory.getLogger(SxStudentServiceImpl.class);

    @Override
    public SxIdentifyForm saveIndentifyForm(SxStudent sxStudent, String practiceContent, String selfSummary) {
        //实习内容，自我总结
        SxIdentifyForm sxIdentifyForm = sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
        sxIdentifyForm.setSxContent(practiceContent);
        sxIdentifyForm.setSelfSummary(selfSummary);
        sxIdentifyFormRepository.save(sxIdentifyForm);
        return sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
    }

    @Override
    public SxReport stage1_summary(SxStudent sxStudent, String stage1_summary) {
        SxReport sxReport = sxReportRepository.findByStuNo(sxStudent.getStuNo());
        if (sxReport != null) {
            sxReport.setStage1Summary(stage1_summary);
            sxReportRepository.save(sxReport);
            return sxReportRepository.findByStuNo(sxStudent.getStuNo());
        }
        return null;
    }

    @Override
    public SxStudent findSelfInfoByStuNo(String StuNo) {
        return resp.findByStuNo(StuNo);
    }

    @Override
    public void save(SxStudent sxStudent) {
        resp.save(sxStudent);
    }

    @Override
    public SxReport stage2_summary(SxStudent sxStudent, String stage2_summary) {
        SxReport sxReport = sxReportRepository.findByStuNo(sxStudent.getStuNo());
        if (sxReport != null) {
            sxReport.setStage2Summary(stage2_summary);
            sxReportRepository.save(sxReport);
            return sxReportRepository.findByStuNo(sxStudent.getStuNo());
        }
        return null;
    }

    @Override
    public SxTeacher getTeacherInfo(SxStudent sxStudent) {
        SxTeacher sxTeacher = sxTeacherRepository.findByTeacherNo(sxStudent.getTeacherNo());
        return sxTeacher;
    }

    @Override
    public SxIdentifyForm getSelfIndentifyInfo(SxStudent sxStudent) {
        SxIdentifyForm sxIdentifyForm = sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
        return sxIdentifyForm;
    }

    @Override
    public SxReport getSelfReportInfo(SxStudent sxStudent) {
        SxReport sxReport = sxReportRepository.findByStuNo(sxStudent.getStuNo());
        return sxReport;
    }

    @Override
    public SxStudent findByStuNo(String StuNo) {
        return resp.findByStuNo(StuNo);
    }
}
