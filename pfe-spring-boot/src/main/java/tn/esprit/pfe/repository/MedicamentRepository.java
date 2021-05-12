package tn.esprit.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pfe.entities.Medicament;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long>{

}
