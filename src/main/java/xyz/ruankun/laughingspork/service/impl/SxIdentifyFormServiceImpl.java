package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.service.SxIdentifyFormService;
import xyz.ruankun.laughingspork.repository.SxIdentifyFormRepository;

@Service
public class SxIdentifyFormServiceImpl implements SxIdentifyFormService {
	@Autowired
	private SxIdentifyFormRepository resp;
}
