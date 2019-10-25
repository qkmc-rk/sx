package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.repository.SxIdentifyFormRepository;
import xyz.ruankun.laughingspork.repository.SxReportRepository;
import xyz.ruankun.laughingspork.service.SxStudentService;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;

import java.util.List;
import java.util.Optional;


@Service
public class SxStudentServiceImpl implements SxStudentService {
	@Autowired
	private SxStudentRepository sxStudentRepository;
	@Autowired
	private SxReportRepository sxReportRepository;

	@Autowired
	private SxIdentifyFormRepository sxIdentifyFormRepository;

	@Override
	public List<SxStudent> getByTeacherNo(String teacherNo) {
		List<SxStudent> sxStudentList = sxStudentRepository.findByTeacherNo(teacherNo);
		if(sxStudentList.isEmpty()){return null;}
		return sxStudentList;
	}


	@Override
	public List<SxStudent> getGroupList(String groupCode) {
		List<SxStudent> sxStudentList = sxStudentRepository.findByGroupCode(groupCode);
		if (sxStudentList.isEmpty()){
			return null;
		}
		return sxStudentList;
	}

	@Override
	public SxStudent getByStuNo(String StuNo) {
		SxStudent sxStudent = sxStudentRepository.findByStuNo(StuNo);
		if (sxStudent == null){return null;}
		return sxStudent;
	}
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
		SxReport sxReport = sxReportRepository.getSxReportByStuNo(sxStudent.getStuNo());
		sxReport.setStage1Comment(stage1_summary);
		sxReportRepository.save(sxReport);
		return sxReportRepository.getSxReportByStuNo(sxStudent.getStuNo());
	}

	@Override
	public SxReport stage2_summary(SxStudent sxStudent, String stage2_summary) {
		SxReport sxReport = sxReportRepository.getSxReportByStuNo(sxStudent.getStuNo());
		sxReport.setStage1Comment(stage2_summary);
		sxReportRepository.save(sxReport);
		return sxReportRepository.getSxReportByStuNo(sxStudent.getStuNo());
	}

	@Override
	public SxReport stage3_summary(SxStudent sxStudent, String stage3_summary) {
		SxReport sxReport = sxReportRepository.getSxReportByStuNo(sxStudent.getStuNo());
		sxReport.setStage1Comment(stage3_summary);
		sxReportRepository.save(sxReport);
		return sxReportRepository.getSxReportByStuNo(sxStudent.getStuNo());
	}
}
