package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxCorpTeacher;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SxCorpTeacherRepository extends JpaRepository<SxCorpTeacher, Long>{

}
