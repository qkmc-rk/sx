package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SxIdentifyFormRepository extends JpaRepository<SxIdentifyForm, Long>{

    SxIdentifyForm findByStuNo(String stuNo);
}
