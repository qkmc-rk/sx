package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxCollegePrincipal;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.repository.SxIdentifyFormRepository;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;
import xyz.ruankun.laughingspork.service.SxCollegePrincipalService;
import xyz.ruankun.laughingspork.repository.SxCollegePrincipalRepository;

import java.util.Date;
import java.util.List;

@Service
public class SxCollegePrincipalServiceImpl implements SxCollegePrincipalService {
	@Autowired
	private SxCollegePrincipalRepository resp;
	@Autowired
	private SxStudentRepository sxStudentRepository;
	@Autowired
	private SxIdentifyFormRepository sxIdentifyFormRepository;
	@Override
	public List<SxStudent> getOwnedStudentsList(SxCollegePrincipal sxCollegePrincipal) {
		return sxStudentRepository.findByCollege(sxCollegePrincipal.getCollege());
	}

	@Override
	public SxIdentifyForm getIdentifyFormByStuId(SxStudent sxStudent) {
		return sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
	}

	@Override
	public SxIdentifyForm operateIdentifyForm(SxStudent sxStudent,String collegePrincipalOpinion, String comprehsvGrade) {
		SxIdentifyForm oldForm=sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
		oldForm.setCollegePrincipalOpinion(collegePrincipalOpinion);
		oldForm.setCPODate((java.sql.Date) new Date());
		oldForm.setComprehsvGrade(comprehsvGrade);
		oldForm.setCGDate((java.sql.Date) new Date());
		sxIdentifyFormRepository.save(oldForm);
		return sxIdentifyFormRepository.findByStuNo(sxStudent.getStuNo());
	}
}
