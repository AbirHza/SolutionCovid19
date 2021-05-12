package tn.esprit.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.pfe.entities.MailHistory;

public interface MailHistoryRepository extends  JpaRepository<MailHistory, Long> {

}
