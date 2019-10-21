package xyz.ruankun.laughingspork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private SxStudentRepository sxStudentRepository;

    @GetMapping("/getAll")
    public List<SxStudent> getAllStudent() {
        return sxStudentRepository.findAll();
    }
}
