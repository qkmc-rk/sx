package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxStagemanage;
import xyz.ruankun.laughingspork.service.SxStagemanageService;
import xyz.ruankun.laughingspork.repository.SxStagemanageRepository;

@Service
public class SxStagemanageServiceImpl implements SxStagemanageService {
	@Autowired
	private SxStagemanageRepository resp;
}
