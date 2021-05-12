package tn.esprit.pfe.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pfe.entities.Ordonnance;
import tn.esprit.pfe.repository.OrdonnanceRepository;

@Service
public class OrdonnanceServiceImpl implements IOrdonnanceService {
	public static final Logger l= LogManager.getLogger(UserServiceImpl.class);
	@Autowired
	OrdonnanceRepository ordonnanceRepository;


	@Override
	public Ordonnance addOrdonnance(Ordonnance o) {
		// TODO Auto-generated method stub
		return this.ordonnanceRepository.save(o);
	}

	@Override
	public Ordonnance updateOrdonnance(Ordonnance o, Long num_ORD) {
		// TODO Auto-generated method stub
		o.setNum_ORD(num_ORD);
		return this.ordonnanceRepository.save(o);	
	}

	@Override
	public void deleteOrdonnance(Long num_ORD) {
		// TODO Auto-generated method stub
		this.ordonnanceRepository.deleteById(num_ORD);
	}

	@Override
	public List<Ordonnance> retrieveAllOrdonnance() {
		// TODO Auto-generated method stub
		List<Ordonnance> ordonnances = (List<Ordonnance>)ordonnanceRepository.findAll(); 
		for  (Ordonnance ordonnance : ordonnances) {
			l.info("ordonnance +++ : "+ordonnance);		
		}
		return ordonnances;
	}

}
