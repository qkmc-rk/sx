package xyz.ruankun.laughingspork.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.*;
import xyz.ruankun.laughingspork.repository.*;
import xyz.ruankun.laughingspork.service.SxStudentService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private SxStagemanageRepository sxStagemanageRepository;

    @Autowired
    private SxStudentRepository sxStudentRepository;



    @Override
    public SxIdentifyForm saveIdentifyForm(SxStudent sxStudent, String practiceContent, String selfSummary) {
        //实习内容，自我总结
        SxIdentifyForm sxIdentifyForm = sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
        if (sxIdentifyForm == null) {
            return null;
        }
        sxIdentifyForm.setSxContent(practiceContent);
        sxIdentifyForm.setSelfSummary(selfSummary);
        sxIdentifyFormRepository.save(sxIdentifyForm);
        return sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
    }

    @Override
    public SxReport stage1_summary(SxStudent sxStudent, String stage1_summary, String stage1GuideWay, String stage1GuideDate) {
        SxReport sxReport = sxReportRepository.findSxReportByStuNo(sxStudent.getStuNo());
        SxStagemanage sxStagemanage = sxStagemanageRepository.getSxStagemanageById(1);
        if (!sxStagemanage.getIsReportStage1Open()){return null;}
        sxReport.setStage1Summary(stage1_summary);
        sxReport.setStage1GuideWay(stage1GuideWay);
        sxReport.setStage1GuideDate(stage1GuideDate);
        sxReportRepository.save(sxReport);
        return sxReportRepository.findSxReportByStuNo(sxStudent.getStuNo());
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
    public SxReport stage2_summary(SxStudent sxStudent, String stage2_summary, String stage2GuideWay, String stage2GuideDate) {
        SxReport sxReport = sxReportRepository.findSxReportByStuNo(sxStudent.getStuNo());
        SxStagemanage sxStagemanage = sxStagemanageRepository.getSxStagemanageById(1);
        if (!sxStagemanage.getIsReportStage2Open()){return null;}
        sxReport.setStage2Summary(stage2_summary);
        sxReport.setStage2GuideWay(stage2GuideWay);
        sxReport.setStage2GuideDate(stage2GuideDate);
        sxReportRepository.save(sxReport);
        return sxReportRepository.findSxReportByStuNo(sxStudent.getStuNo());
    }

    @Override
    public SxTeacher getTeacherInfo(SxStudent sxStudent) {
        SxTeacher sxTeacher = sxTeacherRepository.findByTeacherNo(sxStudent.getTeacherNo());
        return sxTeacher;
    }

    @Override
    public SxIdentifyForm getSelfIdentifyInfo(SxStudent sxStudent) {
        SxIdentifyForm sxIdentifyForm = sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
        return sxIdentifyForm;
    }

    @Override
    public SxReport getSelfReportInfo(SxStudent sxStudent) {
        SxReport sxReport = sxReportRepository.findSxReportByStuNo(sxStudent.getStuNo());
        return sxReport;
    }

    @Override
    public SxStudent findByStuNo(String StuNo) {
        return resp.findByStuNo(StuNo);
    }

    @Override
    public Boolean testAuth(String tNo, String stuNO) {
            if (resp.findByStuNoAndTeacherNo(stuNO, tNo) == null) {
                return false;
            } else return true;
    }

    @Override
    public SxStagemanage getNowReportStage() {
        SxStagemanage sxStagemanage = sxStagemanageRepository.getSxStagemanageById(1);
        return sxStagemanage;
    }

    @Override
    public List<SxTeacher> collegeTeacher(SxStudent sxStudent) {
        List<SxTeacher> sxTeacher = sxTeacherRepository.findAllByCollegeCode(sxStudent.getCollegeCode());
        if (sxTeacher.isEmpty()){
            return null;
        }
        return sxTeacher;
    }

    @Override
    public SxStudent choseCollegeTeacher(SxStudent sxStudent, String tNO) {
        sxStudent.setTeacherNo(tNO);
        sxStudentRepository.save(sxStudent);
        return sxStudent;
    }

}
