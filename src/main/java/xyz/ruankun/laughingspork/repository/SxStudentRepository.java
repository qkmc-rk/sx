package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxStudent;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SxStudentRepository extends JpaRepository<SxStudent, Long>{

}
