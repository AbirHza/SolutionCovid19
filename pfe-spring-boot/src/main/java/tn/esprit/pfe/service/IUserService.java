package tn.esprit.pfe.service;


import java.util.List;

import org.springframework.security.core.Authentication;

import tn.esprit.pfe.entities.Utilisateur;

public interface IUserService {
	Utilisateur addUser(Utilisateur u);
	Utilisateur updateUtilisateur (Utilisateur u);
	Utilisateur updateUser(Utilisateur u, Authentication auth);
	void deleteUser(Long id);
	List<Utilisateur> retrieveAllUsers();
	List<Utilisateur> findByNom(String nom);
	//public Utilisateur getUserById(String matricule);
	public Utilisateur getMyInfo(Authentication auth);
	public List<String> getRoleById(Long id);
	public Utilisateur findByUsername(String username);
	public Utilisateur findById(Long id);
}
