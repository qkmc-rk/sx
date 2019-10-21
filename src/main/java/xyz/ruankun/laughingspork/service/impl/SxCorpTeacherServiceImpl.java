package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxCorpTeacher;
import xyz.ruankun.laughingspork.service.SxCorpTeacherService;
import xyz.ruankun.laughingspork.repository.SxCorpTeacherRepository;

@Service
public class SxCorpTeacherServiceImpl implements SxCorpTeacherService {
	@Autowired
	private SxCorpTeacherRepository resp;
}
