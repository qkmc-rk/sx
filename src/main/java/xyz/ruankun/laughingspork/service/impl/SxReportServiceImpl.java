package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.service.SxReportService;
import xyz.ruankun.laughingspork.repository.SxReportRepository;

@Service
public class SxReportServiceImpl implements SxReportService {
	@Autowired
	private SxReportRepository resp;
}
