package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxStagemanage;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SxStagemanageRepository extends JpaRepository<SxStagemanage, Long>{

}
