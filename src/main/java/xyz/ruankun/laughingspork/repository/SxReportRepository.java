package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxReport;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface SxReportRepository extends JpaRepository<SxReport, Long>{
    SxReport findSxReportByStuNo(String stuNo);
}
