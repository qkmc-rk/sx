package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxRoot;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SxRootRepository extends JpaRepository<SxRoot, Long>{

}
