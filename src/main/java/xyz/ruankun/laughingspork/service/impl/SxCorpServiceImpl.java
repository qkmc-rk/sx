package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxCorp;
import xyz.ruankun.laughingspork.service.SxCorpService;
import xyz.ruankun.laughingspork.repository.SxCorpRepository;

@Service
public class SxCorpServiceImpl implements SxCorpService {
	@Autowired
	private SxCorpRepository resp;
}
