package tn.esprit.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pfe.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
