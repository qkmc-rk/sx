package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.service.SxRootService;
import xyz.ruankun.laughingspork.repository.SxRootRepository;

@Service
public class SxRootServiceImpl implements SxRootService {
	@Autowired
	private SxRootRepository resp;
}
