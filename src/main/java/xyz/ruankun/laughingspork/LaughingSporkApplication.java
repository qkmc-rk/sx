package xyz.ruankun.laughingspork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.ruankun.laughingspork.controller.StudentController;

@SpringBootApplication
//@MapperScan("xyz.ruankun.laughingspork")
public class LaughingSporkApplication {

    public static void main(String[] args) {

        SpringApplication.run(LaughingSporkApplication.class, args);
        //new StudentController().getAllStudent();
    }

}
