package tn.esprit.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pfe.entities.Reponse;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Long> {

}
