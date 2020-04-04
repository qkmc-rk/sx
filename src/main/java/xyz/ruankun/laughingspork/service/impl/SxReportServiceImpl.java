package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;
import xyz.ruankun.laughingspork.service.SxReportService;
import xyz.ruankun.laughingspork.repository.SxReportRepository;

import java.util.Optional;

@Service
public class SxReportServiceImpl implements SxReportService {
    @Autowired
    private SxReportRepository sxReportRepository;

    @Autowired
    SxStudentRepository sxStudentRepository;

    @Override
    public SxReport getReportInfo(String stuNo) {
        SxReport sxReport = sxReportRepository.findSxReportByStuNo(stuNo);
        if (sxReport == null) {
            return null;
        }
        return sxReport;
    }

    @Override
    @Transactional
    public SxReport saveReport(SxReport sxReport) {
        SxReport newReport = sxReportRepository.saveAndFlush(sxReport);
        SxStudent sxStudent = sxStudentRepository.findByStuNo(newReport.getStuNo());

        // 更新filled flag 学生填写状态
        int reportFilledFlag = 0;
        if (!StringUtils.isEmpty(newReport.getStage1Summary())) reportFilledFlag++;
        if (!StringUtils.isEmpty(newReport.getStage2Summary())) reportFilledFlag++;


        // 更新flag 教师填写状态
        int reportFlag = 0;
        if (!StringUtils.isEmpty(newReport.getStage1Comment())) reportFlag++;
        if (!StringUtils.isEmpty(newReport.getStage2Comment())) reportFlag++;
        if (!StringUtils.isEmpty(newReport.getStage1Grade())) reportFlag++;
        if (!StringUtils.isEmpty(newReport.getStage2Grade())) reportFlag++;
        if (!StringUtils.isEmpty(newReport.getTotalScore())) reportFlag++;
        if (!StringUtils.isEmpty(newReport.getTotalGrade())) reportFlag++;
        if (reportFlag > 5) {
            // 六个都不为空 则已填完
            reportFlag = 2;
        } else if (reportFlag > 0) {
            // 部分不为空 未填完整
            reportFlag = 1;
        }

        sxStudent.setReportFlag(reportFlag);
        sxStudent.setReportFilledFlag(reportFilledFlag);
        sxStudentRepository.saveAndFlush(sxStudent);
        return newReport;
    }


}
