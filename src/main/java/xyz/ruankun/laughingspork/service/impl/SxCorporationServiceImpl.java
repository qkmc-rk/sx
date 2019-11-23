package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxCorporation;
import xyz.ruankun.laughingspork.service.SxCorporationService;
import xyz.ruankun.laughingspork.repository.SxCorporationRepository;

@Service
public class SxCorporationServiceImpl implements SxCorporationService {
	@Autowired
	private SxCorporationRepository resp;
}
