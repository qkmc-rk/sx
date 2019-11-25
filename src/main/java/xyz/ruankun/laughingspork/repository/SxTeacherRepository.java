package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxTeacher;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface SxTeacherRepository extends JpaRepository<SxTeacher, Long>{
    SxTeacher findByTeacherNo(String teacherNo);
    List<SxTeacher> findAllByCollegeCode(String collegeCode);
}
