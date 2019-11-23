package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxCorporation;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SxCorporationRepository extends JpaRepository<SxCorporation, Long>{

}
