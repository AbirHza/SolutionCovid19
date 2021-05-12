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
import tn.esprit.pfe.entities.Reponse;
import tn.esprit.pfe.service.IReponseService;

@RestController
public class ReponseRestController {
	@Autowired
	IReponseService reponseService;
	
	@GetMapping("/retrieve-all-reponses")
	@ResponseBody
	public List<Reponse> getReponse() {
		List<Reponse> list = reponseService.retrieveAllReponse();
		return list;
	}

	@PostMapping("/add-reponse")
	public Reponse addReponse(@RequestBody Reponse r) {
		Reponse reponse = reponseService.addReponse(r);
		return reponse;
	}

	@PutMapping("/modify-reponse/{id}")
	@ResponseBody
	public Reponse modifyReponse(@PathVariable(name="id") Long id, @RequestBody Reponse r) {
		return reponseService.updateReponse(r, id);
	}

	@DeleteMapping(value="/listReponse/{id}")
	public void delete(@PathVariable(name="id") Long id){
		reponseService.deleteReponse(id);
	}
}
