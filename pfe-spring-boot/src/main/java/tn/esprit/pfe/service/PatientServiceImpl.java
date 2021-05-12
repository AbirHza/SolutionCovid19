package tn.esprit.pfe.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.pfe.entities.Patient;
import tn.esprit.pfe.entities.Utilisateur;
import tn.esprit.pfe.repository.PatientRepository;
import tn.esprit.pfe.repository.UserRepository;

@Service
public class PatientServiceImpl implements IPatientService {

	public static final Logger l= LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public Patient addPatient(Patient p) {
		// TODO Auto-generated method stub
		return this.patientRepository.save(p);
	}

	@Override
	public Patient updatePatient(Patient p, Long id) {
		// TODO Auto-generated method stub
		p.setId(id);
		return this.patientRepository.save(p);	
	}

	@Override
	public void deletePatient(Long id) {
		// TODO Auto-generated method stub
		this.patientRepository.deleteById(id);
	}


	@Override
	public List<Patient> retrieveAllPatients() {
		// TODO Auto-generated method stub
		List<Patient> patients = (List<Patient>)patientRepository.findAll(); 
		for  (Patient patient : patients) {
			l.info("patient +++ : "+patient);		
		}
		return patients;
	}

	@Override
	public Patient listPatients(Long id) {
		// TODO Auto-generated method stub
		return this.patientRepository.findById(id).get();
	}

	@Override
	public void affecterPatientAMedecin(Long iduser, Long idpatient) {
		// TODO Auto-generated method stub
		Patient patient =patientRepository.findById(idpatient).get();
		Utilisateur medecin= userRepository.findById(iduser).orElse(new Utilisateur());
		if(!ObjectUtils.isEmpty(medecin) && !ObjectUtils.isEmpty(patient)){
			patient.setMedecin(medecin);

		}
	}





}
