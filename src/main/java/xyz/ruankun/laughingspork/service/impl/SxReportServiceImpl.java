package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	@Override
	public SxReport getReportInfo(String stuNo) {
		SxReport sxReport = sxReportRepository.findByStuNo(stuNo);
		if (sxReport == null){
			return null;
		}
		return sxReport;
	}


}
