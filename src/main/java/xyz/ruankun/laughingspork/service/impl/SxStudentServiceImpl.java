package xyz.ruankun.laughingspork.service.impl;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.ruankun.laughingspork.entity.*;
import xyz.ruankun.laughingspork.repository.*;
import xyz.ruankun.laughingspork.service.SxIdentifyFormService;
import xyz.ruankun.laughingspork.service.SxReportService;
import xyz.ruankun.laughingspork.service.SxStudentService;
import xyz.ruankun.laughingspork.util.DateUtil;

import java.sql.Date;
import java.util.List;

@Service
public class SxStudentServiceImpl implements SxStudentService {

    public static final Logger logger = LoggerFactory.getLogger(SxStudentServiceImpl.class);

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

    @Autowired
    private SxIdentifyFormService sxIdentifyFormService;

    @Autowired
    private SxReportService sxReportService;


    @Override
    @Transactional
    public SxIdentifyForm saveIdentifyForm(SxStudent sxStudent, String practiceContent, String selfSummary, String corpOpinion, String corpTeacherOpinion) {
        //实习内容，自我总结
        SxIdentifyForm sxIdentifyForm = sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
        sxIdentifyForm.setSxContent(practiceContent);
        sxIdentifyForm.setSelfSummary(selfSummary);
        sxIdentifyForm.setCorpOpinion(corpOpinion);
        sxIdentifyForm.setCorpTeacherOpinion(corpTeacherOpinion);

        sxIdentifyForm.setCODate(DateUtil.getSqlDate());
        sxIdentifyForm.setCTODate(DateUtil.getSqlDate());
        sxIdentifyFormService.saveIdentifyForm(sxIdentifyForm);
//        sxStudentRepository.saveAndFlush(sxStudent);
        return sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
    }

    @Override
    public SxReport setStage1Summary(/*Date gmtStart,*/ SxStudent sxStudent, String stage1Summary, String stage1GuideWay, String stage1GuideDate) {
        SxReport sxReport = sxReportRepository.findSxReportByStuNo(sxStudent.getStuNo());
        SxStagemanage sxStagemanage = sxStagemanageRepository.getSxStagemanageById(1);
        if (!sxStagemanage.getIsReportStage1Open()) {
            return null;
        }
        sxReport.setStage1Date(DateUtil.getSqlDate());
        sxReport.setStage1Summary(stage1Summary);
        sxReport.setStage1GuideWay(stage1GuideWay);
        sxReport.setStage1GuideDate(stage1GuideDate);
        return sxReportService.saveReport(sxReport);
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
    @Transactional
    public SxReport setStage2Summary(/*Date gmtEnd, */SxStudent sxStudent, String stage2Summary, String stage2GuideWay, String stage2GuideDate) {
        SxReport sxReport = sxReportRepository.findSxReportByStuNo(sxStudent.getStuNo());
        sxStudent = sxStudentRepository.findByStuNo(sxStudent.getStuNo());
        SxStagemanage sxStagemanage = sxStagemanageRepository.getSxStagemanageById(1);
        if (!sxStagemanage.getIsReportStage2Open()) {
            return null;
        }
        sxReport.setStage2Date(DateUtil.getSqlDate());
        sxReport.setStage2Summary(stage2Summary);
        sxReport.setStage2GuideWay(stage2GuideWay);
        sxReport.setStage2GuideDate(stage2GuideDate);
        sxStudentRepository.save(sxStudent);
        return sxReportService.saveReport(sxReport);
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
        } else {
            return true;
        }
    }

    @Override
    public SxStagemanage getNowReportStage() {
        SxStagemanage sxStagemanage = sxStagemanageRepository.getSxStagemanageById(1);
        return sxStagemanage;
    }

    @Override
    public List<SxTeacher> collegeTeacher(SxStudent sxStudent) {
        List<SxTeacher> sxTeacher = sxTeacherRepository.findAllByCollegeCode(sxStudent.getCollegeCode());
        if (sxTeacher.isEmpty()) {
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

    @Override
    public void updatePosition(String stuNo, String position) {
        SxStudent sxStudent = resp.findByStuNo(stuNo);
        if (sxStudent != null) {
            sxStudent.setCorpPosition(position);
            resp.save(sxStudent);
        }
    }

    @Override
    public boolean updatePassword(String stuNo, String oldPassword, String newPassword) {
        newPassword = newPassword.trim();
        SxStudent sxStudent = sxStudentRepository.findByStuNo(stuNo);
        oldPassword = new Md5Hash(oldPassword).toString().toUpperCase();
        if (oldPassword.equals(sxStudent.getPassword())) {
            sxStudent.setPassword(new Md5Hash(newPassword).toString().toUpperCase());
            resp.save(sxStudent);
        } else {
            return false;
        }
        return true;
    }

}
