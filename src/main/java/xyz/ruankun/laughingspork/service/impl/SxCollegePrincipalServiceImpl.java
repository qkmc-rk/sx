package xyz.ruankun.laughingspork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxCollegePrincipal;
import xyz.ruankun.laughingspork.service.SxCollegePrincipalService;
import xyz.ruankun.laughingspork.repository.SxCollegePrincipalRepository;

@Service
public class SxCollegePrincipalServiceImpl implements SxCollegePrincipalService {
	@Autowired
	private SxCollegePrincipalRepository resp;
}
