package xyz.ruankun.laughingspork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.service.SxIdentifyFormService;
import xyz.ruankun.laughingspork.util.EntityUtil;

import java.util.IdentityHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaughingSporkApplicationTests {
    public static final Logger logger = LoggerFactory.getLogger(LaughingSporkApplication.class);

    @Autowired
    SxIdentifyFormService sxIdentifyFormService;

    @Test
    public void contextLoads() {

    }
}
