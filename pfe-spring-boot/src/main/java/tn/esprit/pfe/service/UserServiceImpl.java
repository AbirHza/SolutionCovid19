package tn.esprit.pfe.service;



import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javassist.NotFoundException;
import tn.esprit.pfe.entities.ERole;
import tn.esprit.pfe.entities.Patient;
import tn.esprit.pfe.entities.Role;
import tn.esprit.pfe.entities.Utilisateur;
import tn.esprit.pfe.repository.PatientRepository;
import tn.esprit.pfe.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	public static final Logger l= LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public Utilisateur addUser(Utilisateur u) {
		// TODO Auto-generated method stub
		return this.userRepository.save(u);
	}



	
	@Override
	public List<Utilisateur> retrieveAllUsers() {
		// TODO Auto-generated method stub
		List<Utilisateur> users = (List<Utilisateur>)userRepository.findAll(); 
		for  (Utilisateur user : users) {
			l.info("user +++ : "+user);		
		}
		return users;
	}

	
	@Override
	public List<Utilisateur> findByNom(String nom) {
		// TODO Auto-generated method stub
		return this.findByNom(nom);
	}

	@Override
	public Utilisateur updateUser(Utilisateur u, Authentication auth) {
		// TODO Auto-generated method stub
		Utilisateur u1= userRepository.findByUsername(auth.getName());
		
		if(!u.getPrenom().equals(""))
			u1.setPrenom(u.getPrenom());
		if(!u.getSexe().equals(""))
			u1.setSexe(u.getSexe());
		if(!u.getEmail().equals(""))
			u1.setEmail(u.getEmail());
		if(!u.getNom().equals(""))
			u1.setNom(u.getNom());
		if(!(u.getPassword() == null))
			u1.setPassword(encoder.encode(u.getPassword()));
		
		userRepository.save(u1);
		
		return u1;
	}

	

	@Override
	public Utilisateur getMyInfo(Authentication auth) {
		// TODO Auto-generated method stub
		Utilisateur u =new Utilisateur();
		u = userRepository.findByUsername(auth.getName());

		return u;
	}


	@Override
	public List<String> getRoleById(Long id) {
		// TODO Auto-generated method stub
	Utilisateur user = userRepository.findById(id).get();
	List<String> l =new ArrayList<String>();
	for (Role r : user.getRoles()){
		if (r.getName().equals(ERole.ROLE_ADMINISTRATEUR)){
			l.add("administrateur");
		}
		if(r.getName().equals(ERole.ROLE_INFIRMIER)){
			l.add("Infirmier");
		}
		if(r.getName().equals(ERole.ROLE_MEDECIN)){
			l.add("Medecin");
		}
		if(r.getName().equals(ERole.ROLE_RADIOLOGUE)){
			l.add("Radiologue");
		}
	}
	return l;
	}



	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
	}




	@Override
	public Utilisateur findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}




	@Override
	public Utilisateur findById(Long id) {
		return userRepository.findById(id).get();
	}




	@Override
	public Utilisateur updateUtilisateur(Utilisateur u) {
		if(userRepository.existsById(u.getId())) {
			return userRepository.findById(u.getId()).get();
		}
		return null;
	}







}
