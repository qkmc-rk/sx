package xyz.ruankun.laughingspork.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.service.SxIdentifyFormService;
import xyz.ruankun.laughingspork.repository.SxIdentifyFormRepository;


@Service
public class SxIdentifyFormServiceImpl implements SxIdentifyFormService {
    @Autowired
    private SxIdentifyFormRepository sxIdentifyFormRepository;

    public static final Logger logger = LoggerFactory.getLogger(SxIdentifyFormServiceImpl.class);

    @Override
    public SxIdentifyForm getIdentifyInfo(String stuNo) {
        SxIdentifyForm sxIdentifyFormOptional = sxIdentifyFormRepository.findByStuNo(stuNo);
        if (sxIdentifyFormOptional == null) {
            return null;
        }
        return sxIdentifyFormOptional;
    }

    @Override
    public void saveIdentifyForm(SxIdentifyForm sxIdentifyForm) {
        sxIdentifyFormRepository.save(sxIdentifyForm);
    }
}
