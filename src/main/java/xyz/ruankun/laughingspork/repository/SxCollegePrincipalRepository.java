package xyz.ruankun.laughingspork.repository;

import xyz.ruankun.laughingspork.entity.SxCollegePrincipal;
        import org.springframework.stereotype.Repository;
        import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SxCollegePrincipalRepository extends JpaRepository<SxCollegePrincipal, Long>{

}
