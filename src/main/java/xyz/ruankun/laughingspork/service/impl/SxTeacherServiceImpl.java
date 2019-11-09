package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.entity.SxTeacher;
import xyz.ruankun.laughingspork.repository.SxIdentifyFormRepository;
import xyz.ruankun.laughingspork.repository.SxReportRepository;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;
import xyz.ruankun.laughingspork.service.SxTeacherService;
import xyz.ruankun.laughingspork.repository.SxTeacherRepository;
import xyz.ruankun.laughingspork.util.DateUtil;

import java.util.List;

@Service
public class SxTeacherServiceImpl implements SxTeacherService {
    @Autowired
    private SxTeacherRepository resp;
    @Autowired
    private SxIdentifyFormRepository sxIdentifyFormRepository;
    @Autowired
    private SxStudentRepository sxStudentRepository;
    @Autowired
    private SxReportRepository sxReportRepository;

    @Override
    public List<SxStudent> getStudentListByTeacherNo(SxTeacher sxTeacher) {
        return sxStudentRepository.findByTeacherNo(sxTeacher.getTeacherNo());
    }

    @Override
    public Boolean isIdentifyFlag(SxStudent sxStudent) {
        SxIdentifyForm sxIdentifyForm=sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
        if(sxIdentifyForm == null ){
            return null;
        }else {
            if(sxIdentifyForm.getCorpTeacherOpinion() == null || sxIdentifyForm.getCorpTeacherOpinion().equals("")||
                    sxIdentifyForm.getCorpOpinion() == null || sxIdentifyForm.getCorpOpinion().equals("")||
                    sxIdentifyForm.getCorpTeacherGrade() == null || sxIdentifyForm.getCorpTeacherGrade().equals("")||
                    sxIdentifyForm.getTeacherGrade() == null || sxIdentifyForm.getTeacherGrade().equals("")||
                    sxIdentifyForm.getComprehsvGrade() == null ||sxIdentifyForm.getComprehsvGrade().equals("")||
                    sxIdentifyForm.getCollegePrincipalOpinion() == null||sxIdentifyForm.getCollegePrincipalOpinion().equals(""))
            {
                sxStudent.setIdentifyFlag(false);
                sxStudentRepository.save(sxStudent);
                return false;
            }else {
                sxStudent.setIdentifyFlag(true);
                sxStudentRepository.save(sxStudent);
                return true;
            }
        }

    }

    @Override
    public Boolean isReportFlag(SxStudent sxStudent) {
        SxReport sxReport=sxReportRepository.findSxReportByStuNo(sxStudent.getStuNo());
        if(sxReport == null){
            return null;
        }else {
            if(sxReport.getStage1Comment() == null ||  sxReport.getStage1Comment().equals("")||
                    sxReport.getStage1Grade() == null || sxReport.getStage1Grade().equals("") ||
                    sxReport.getStage2Comment() == null || sxReport.getStage2Comment().equals("")||
                    sxReport.getStage2Grade() == null ||sxReport.getStage2Grade().equals("")||
                    sxReport.getTotalGrade() == null || sxReport.getTotalGrade().equals("")||
                    sxReport.getTotalScore() == null || sxReport.getTotalScore().equals("")){
                sxStudent.setReportFlag(false);
                sxStudentRepository.save(sxStudent);
                return false;
            }else {
                sxStudent.setReportFlag(true);
                sxStudentRepository.save(sxStudent);
                return true;
            }
        }

    }


    @Override
    public SxTeacher findByTeacherNo(String teacherNo) {
        return resp.findByTeacherNo(teacherNo);
    }

    @Override
    public SxReport saveReport1(String stuNo, String stage1_comment, String stage1_grade) {
        SxReport sxReport = sxReportRepository.findSxReportByStuNo(stuNo);
        sxReport.setStage1Comment(stage1_comment);
        sxReport.setStage1Grade(stage1_grade);
        sxReport.setStage1GuideDate(DateUtil.getCnDateStr());
        sxReportRepository.save(sxReport);
        return sxReport;
    }

    @Override
    public SxReport saveReport2(String stuNo, String stage2_comment, String stage2_grade) {
        SxReport sxReport = sxReportRepository.findSxReportByStuNo(stuNo);
        sxReport.setStage2Comment(stage2_comment);
        sxReport.setStage2Grade(stage2_grade);
        sxReport.setStage2GuideDate(DateUtil.getCnDateStr());
        sxReportRepository.save(sxReport);
        return sxReport;
    }
}
