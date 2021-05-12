package tn.esprit.pfe.service;

import java.util.List;

import tn.esprit.pfe.entities.Medicament;


public interface IMedicamentService {
	Medicament addMedicament(Medicament m);
	Medicament updateMedicament(Medicament m, Long code_Med);
	void deleteMedicament(Long code_Med);
	List<Medicament> retrieveAllMedicament();
}
