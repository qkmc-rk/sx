package xyz.ruankun.laughingspork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.ruankun.laughingspork.util.DateUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LaughingSporkApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(DateUtil.getDateByStr("1996-18-12"));
    }
}
