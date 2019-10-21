package xyz.ruankun.laughingspork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("xyz.ruankun.laughingspork")
public class LaughingSporkApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaughingSporkApplication.class, args);
    }

}
