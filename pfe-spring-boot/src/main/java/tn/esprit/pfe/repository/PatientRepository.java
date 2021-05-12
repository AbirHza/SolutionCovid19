package tn.esprit.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pfe.entities.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
