package tn.esprit.pfe.service;

import java.util.List;

import tn.esprit.pfe.entities.Ordonnance;


public interface IOrdonnanceService {
	Ordonnance addOrdonnance(Ordonnance o);
	Ordonnance updateOrdonnance(Ordonnance o, Long num_ORD);
	void deleteOrdonnance(Long num_ORD);
	List<Ordonnance> retrieveAllOrdonnance();
}
