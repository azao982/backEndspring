package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import classess.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    
}
