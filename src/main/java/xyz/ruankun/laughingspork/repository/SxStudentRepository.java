package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface SxStudentRepository extends JpaRepository<SxStudent, Long> {

    List<SxStudent> findByCorpTeacherNo(String account);

    List<SxStudent> findByCorpName(String corp);

    List<SxStudent> findByCollege(String college);

    List<SxStudent> findByTeacherNo(String teacherNo);

    SxStudent findByStuNo(String stuNo);

    SxStudent findByStuNoAndTeacherNo(String stuNo,String teacherNo);
}