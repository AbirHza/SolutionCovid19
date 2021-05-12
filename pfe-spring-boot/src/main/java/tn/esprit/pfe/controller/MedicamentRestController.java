package tn.esprit.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pfe.entities.Medicament;
import tn.esprit.pfe.service.IMedicamentService;

@RestController
public class MedicamentRestController {
	@Autowired
	IMedicamentService medicamentService;
	
	@GetMapping("/retrieve-all-medicaments")
	@ResponseBody
	public List<Medicament> getMedicaments() {
		List<Medicament> list = medicamentService.retrieveAllMedicament();
		return list;
	}

	@PostMapping("/add-medicament")
	public Medicament addMedicament(@RequestBody Medicament m) {
		Medicament medicament = medicamentService.addMedicament(m);
		return medicament;
	}

	@PutMapping("/modify-medicament/{id}")
	@ResponseBody
	public Medicament modifyMedicament(@PathVariable(name="id") Long code_Med, @RequestBody Medicament m) {
		return medicamentService.updateMedicament(m, code_Med);
	}

	@DeleteMapping(value="/listMedicament/{id}")
	public void delete(@PathVariable(name="id") Long code_Med){
		medicamentService.deleteMedicament(code_Med);
	}
}
