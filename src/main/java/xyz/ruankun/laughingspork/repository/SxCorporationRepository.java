package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxCorporation;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SxCorporationRepository extends JpaRepository<SxCorporation, Long> {

    SxCorporation findByStuNo(String stuNo);

    /**
     * 通过学号删除所有该学号相关的记录
     * @param stuNo 学号
     */
    void deleteAllByStuNo(String stuNo);
}
