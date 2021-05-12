package tn.esprit.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pfe.entities.Utilisateur;
import tn.esprit.pfe.repository.UserRepository;
import tn.esprit.pfe.security.JwtUtils;
import tn.esprit.pfe.service.IUserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/test")
public class UserRestController {

	@Autowired
	IUserService userService;

	@Autowired
	AuthenticationManager authenticationManager;


	@Autowired
	UserRepository userRepository;

	@Autowired
	JwtUtils jwtUtils;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/medecin")
	//@PreAuthorize("hasRole('MEDECIN') or hasRole('INFIRMIER')")
	public String medecinAccess() {
		return "Medecin Board.";
	}
	
	@GetMapping("/admin")
	//@PreAuthorize("hasRole('ADMINISTRATEUR')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/radiologue")
	//@PreAuthorize("hasRole('RADIOLOGUE')")
	public String radiologueAccess() {
		return "Radiologue Board.";
	}
	@PostMapping("/add-user")
	//@PreAuthorize("hasRole('Administrateur')")
	public Utilisateur addUser(@RequestBody Utilisateur u) {
		Utilisateur user = userService.addUser(u);
		return user;
	}
	
	@PutMapping("/modify-user")
	////@PreAuthorize("hasRole('ADMINISTRATEUR') or hasRole('MEDECIN') or hasRole('RADIOLOGUE') or hasRole('INFIRMIER')")
	@ResponseBody
	public Utilisateur modifyUser(@RequestBody Utilisateur user, Authentication auth) {
		return userService.updateUser(user, auth);
	}

	@DeleteMapping("/remove-user/{user-id}")
	////@PreAuthorize("hasRole('ADMINISTRATEUR')")
	@ResponseBody
	public void removeUser(@PathVariable("user-id") Long userId) {
		userService.deleteUser(userId);
	}

	@GetMapping("/retrieve-all-users")
	////@PreAuthorize("hasRole('ADMINISTRATEUR')")
	@ResponseBody
	public List<Utilisateur> getUsers() {
		List<Utilisateur> list = userService.retrieveAllUsers();
		return list;
	}
	
	@GetMapping(value = "/getRoleById/{iduser}")
	////@PreAuthorize("hasRole('ADMINISTRATEUR')")
	@ResponseBody	
	public List<String> getRoleById(@PathVariable("iduser") Long userId) {


		return userService.getRoleById(userId);

	}
	
	@GetMapping(value = "/getByid/{id}")
	public ResponseEntity<Utilisateur> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<Utilisateur>(userService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByUsername/{username}")
	public ResponseEntity<Utilisateur> getByUsername(@PathVariable("username") String username) {
		return new ResponseEntity<Utilisateur>(userService.findByUsername(username), HttpStatus.OK);
	}
	
	 @PutMapping(value= "/updateUser")
	 public ResponseEntity<Utilisateur> UpdateUser(@RequestBody Utilisateur u) {
		 return new ResponseEntity<Utilisateur>(userService.updateUtilisateur(u), HttpStatus.OK);
	 }

	
}
