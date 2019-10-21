package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.service.SxStudentService;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;

@Service
public class SxStudentServiceImpl implements SxStudentService {
	@Autowired
	private SxStudentRepository resp;
}
