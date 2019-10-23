package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxCorp;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.repository.SxIdentifyFormRepository;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;
import xyz.ruankun.laughingspork.service.SxCorpService;
import xyz.ruankun.laughingspork.repository.SxCorpRepository;

import java.util.Date;
import java.util.List;

@Service
public class SxCorpServiceImpl implements SxCorpService {
	@Autowired
	private SxCorpRepository resp;
	@Autowired
	private SxStudentRepository sxStudentRepository;
	@Autowired
	private SxIdentifyFormRepository sxIdentifyFormRepository;
	@Override
	public List<SxStudent> getOwnedStudentsList(SxCorp sxCorp) {
		return sxStudentRepository.findByCorpName(sxCorp.getCorp());
	}
	@Override
	public SxIdentifyForm getIdentifyFormByStuId(String stuNo) {
		return sxIdentifyFormRepository.findByStuNo(stuNo);
	}

	@Override
	public SxIdentifyForm operateIdentifyForm(String stuNo, String corpOpinion) {
		SxIdentifyForm oldForm=sxIdentifyFormRepository.findByStuNo(stuNo);
		oldForm.setCorpOpinion(corpOpinion);
		oldForm.setCODate((java.sql.Date) new Date());
		sxIdentifyFormRepository.save(oldForm);
		return sxIdentifyFormRepository.findByStuNo(stuNo);
	}
}
