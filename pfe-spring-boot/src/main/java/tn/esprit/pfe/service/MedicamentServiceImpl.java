package tn.esprit.pfe.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pfe.entities.Medicament;
import tn.esprit.pfe.repository.MedicamentRepository;

@Service
public class MedicamentServiceImpl implements IMedicamentService {

	public static final Logger l= LogManager.getLogger(UserServiceImpl.class);
	@Autowired
	MedicamentRepository medicamentRepository;
	
	
	@Override
	public Medicament addMedicament(Medicament m) {
		// TODO Auto-generated method stub
		return this.medicamentRepository.save(m);
	}

	@Override
	public Medicament updateMedicament(Medicament m, Long code_Med) {
		// TODO Auto-generated method stub
		m.setCode_Med(code_Med);
		return this.medicamentRepository.save(m);	
	}

	@Override
	public void deleteMedicament(Long code_Med) {
		// TODO Auto-generated method stub
		this.medicamentRepository.deleteById(code_Med);
	}

	@Override
	public List<Medicament> retrieveAllMedicament() {
		// TODO Auto-generated method stub
		List<Medicament> medicaments = (List<Medicament>)medicamentRepository.findAll(); 
		for  (Medicament medicament : medicaments) {
			l.info("medicament +++ : "+medicament);		
		}
		return medicaments;
	}

}
