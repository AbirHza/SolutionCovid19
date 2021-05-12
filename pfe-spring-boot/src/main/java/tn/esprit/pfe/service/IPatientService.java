package tn.esprit.pfe.service;

import java.util.List;

import tn.esprit.pfe.entities.Patient;


public interface IPatientService {
	Patient addPatient(Patient p);
	Patient updatePatient(Patient p, Long id);
	void deletePatient(Long id);
	List<Patient> retrieveAllPatients();
	Patient listPatients(Long id);
	public void affecterPatientAMedecin(Long iduser, Long idpatient);

}
