package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxTeacher;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SxTeacherRepository extends JpaRepository<SxTeacher, Long>{

}
