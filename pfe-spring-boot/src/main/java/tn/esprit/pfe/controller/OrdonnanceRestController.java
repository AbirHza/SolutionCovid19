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
import tn.esprit.pfe.entities.Ordonnance;
import tn.esprit.pfe.service.IOrdonnanceService;

@RestController
public class OrdonnanceRestController {
	@Autowired
	IOrdonnanceService ordonnanceService;

//get all ordonnances test commit
	
	@GetMapping("/retrieve-all-ordonnances")
	@ResponseBody
	public List<Ordonnance> getOrdonnances() {
		List<Ordonnance> list = ordonnanceService.retrieveAllOrdonnance();
		return list;
	}

	@PostMapping("/add-ordonnance")
	public Ordonnance addOrdonnance(@RequestBody Ordonnance o) {
		Ordonnance ordonnance = ordonnanceService.addOrdonnance(o);
		return ordonnance;
	}

	@PutMapping("/modify-ordonnance/{id}")
	@ResponseBody
	public Ordonnance modifyOrdonnance(@PathVariable(name="id") Long num_ORD, @RequestBody Ordonnance o) {
		return ordonnanceService.updateOrdonnance(o, num_ORD);
	}

	@DeleteMapping(value="/listOrdonnance/{id}")
	public void delete(@PathVariable(name="id") Long num_ORD){
		ordonnanceService.deleteOrdonnance(num_ORD);
	}
}
