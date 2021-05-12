package tn.esprit.pfe.service;

import java.util.List;
import tn.esprit.pfe.entities.Reponse;

public interface IReponseService {
	Reponse addReponse(Reponse r);
	Reponse updateReponse(Reponse r, Long id);
	void deleteReponse(Long id);
	List<Reponse> retrieveAllReponse();
}
