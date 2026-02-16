package app.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.pfe.entity.Ordonnance;

@Repository
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Integer> {
    
}
