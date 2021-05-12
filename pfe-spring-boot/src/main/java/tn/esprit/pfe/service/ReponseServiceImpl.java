package tn.esprit.pfe.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pfe.entities.Reponse;
import tn.esprit.pfe.repository.ReponseRepository;

@Service
public class ReponseServiceImpl implements IReponseService {

	
	public static final Logger l= LogManager.getLogger(UserServiceImpl.class);
	@Autowired
	ReponseRepository reponseRepository;
	@Override
	public Reponse addReponse(Reponse r) {
		// TODO Auto-generated method stub
		return this.reponseRepository.save(r);
	}

	@Override
	public Reponse updateReponse(Reponse r, Long id) {
		// TODO Auto-generated method stub
		r.setId(id);
		return this.reponseRepository.save(r);	
	}

	@Override
	public void deleteReponse(Long id) {
		// TODO Auto-generated method stub
		this.reponseRepository.deleteById(id);
	}

	@Override
	public List<Reponse> retrieveAllReponse() {
		// TODO Auto-generated method stub
		List<Reponse> reponses = (List<Reponse>)reponseRepository.findAll(); 
		for  (Reponse reponse : reponses) {
			l.info("reponse +++ : "+reponse);		
		}
		return reponses;
	}
	

}
