package tn.esprit.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pfe.entities.Patient;
import tn.esprit.pfe.service.IPatientService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PatientRestController {
	
	
	@Autowired
	IPatientService patientService;
	
	
	@GetMapping("/retrieve-all-patients")
	//@PreAuthorize("hasRole('MEDECIN') or hasRole('INFIRMIER')")
	@ResponseBody
	public List<Patient> getPatients() {
		List<Patient> list = patientService.retrieveAllPatients();
		return list;
	}

	@PostMapping("/add-patient")
	//@PreAuthorize("hasRole('MEDECIN') or hasRole('INFIRMIER')")
	public Patient addPatient(@RequestBody Patient p) {
		Patient patient = patientService.addPatient(p);
		return patient;
	}

	@PutMapping("/modify-patient/{id}")
	//@PreAuthorize("hasRole('MEDECIN') or hasRole('INFIRMIER')")
	@ResponseBody
	public Patient modifyPatient(@PathVariable(name="id") Long id, @RequestBody Patient p) {
		return patientService.updatePatient(p, id);
	}
	
	@DeleteMapping(value="/listPatients/{id}")
	//@PreAuthorize("hasRole('MEDECIN') or hasRole('INFIRMIER')")
	public void delete(@PathVariable(name="id") Long id){
		patientService.deletePatient(id);
	}
	
	@GetMapping(value="/listPatients/{id}")
	//@PreAuthorize("hasRole('MEDECIN') or hasRole('INFIRMIER')")
	public Patient listPatients(@PathVariable(name="id") Long id){
		return patientService.listPatients(id);
	}
	
	@PutMapping(value ="/affecterPatientAMedecin/{idPatient}/{idMedecin}")
	public void affecterPatientAMedecin(@PathVariable ("idPatient") long patientId, @PathVariable("idMedecin") Long medecinId){
		patientService.affecterPatientAMedecin(patientId,medecinId);
	}
	
}
