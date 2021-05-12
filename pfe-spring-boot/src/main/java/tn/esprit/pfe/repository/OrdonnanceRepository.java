package tn.esprit.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pfe.entities.Ordonnance;

@Repository
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long> {

}
