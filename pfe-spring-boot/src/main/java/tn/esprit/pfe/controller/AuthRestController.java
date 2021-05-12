package tn.esprit.pfe.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pfe.entities.ERole;
import tn.esprit.pfe.entities.Role;
import tn.esprit.pfe.entities.Utilisateur;
import tn.esprit.pfe.payload.JwtResponse;
import tn.esprit.pfe.payload.LoginRequest;
import tn.esprit.pfe.payload.MessageResponse;
import tn.esprit.pfe.payload.SignUpRequest;
import tn.esprit.pfe.repository.RoleRepository;
import tn.esprit.pfe.repository.UserRepository;
import tn.esprit.pfe.security.JwtUtils;
import tn.esprit.pfe.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

	@Autowired
	AuthenticationManager authenticationManager;


	@Autowired
	UserRepository userRepository;


	@Autowired
	RoleRepository roleRepository;


	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;


	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {


		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt,
						userDetails.getId(),
						userDetails.getMatricule(),
						userDetails.getNom(),
						userDetails.getPrenom(),
						userDetails.getSexe(),
						userDetails.getUsername(), 
						userDetails.getEmail(),
						roles));

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		
		if (userRepository.existsByEmail(signUpRequest.getMatricule())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Matricule is already in use!"));
		}

		// Create new user's account
		Utilisateur user = new Utilisateur(
				signUpRequest.getMatricule(),
				signUpRequest.getNom(),
				signUpRequest.getPrenom(),
				signUpRequest.getEmail(),
				signUpRequest.getSexe(),
				signUpRequest.getUsername(), 
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role medecinRole = roleRepository.findByName(ERole.ROLE_MEDECIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(medecinRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMINISTRATEUR)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "infirmier":
					Role infirmierRole = roleRepository.findByName(ERole.ROLE_INFIRMIER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(infirmierRole);

					break;

				case "radiologue":
					Role radiologueRole = roleRepository.findByName(ERole.ROLE_RADIOLOGUE)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(radiologueRole);

					break;
				/*default:
					Role medecinRole = roleRepository.findByName(ERole.ROLE_MEDECIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(medecinRole);*/
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
