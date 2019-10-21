package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxCorp;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SxCorpRepository extends JpaRepository<SxCorp, Long>{

}
