package xyz.ruankun.laughingspork.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.ruankun.laughingspork.util.DateUtil;

import java.util.Calendar;
import java.util.Date;


@RunWith(SpringRunner.class)
public class UserControllerTest {

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Test
    public void login() {
        System.out.println(DateUtil.today());
    }
}
