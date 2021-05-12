package tn.esprit.pfe.payload;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
public class SignUpRequest {
	@NotBlank
	@Size(min = 3, max = 20)
	private String matricule;
	
	@NotBlank
	@Size(min = 3, max = 20)
	private String username;
	@NotBlank
	@Size(min = 3, max = 20)
	private String nom;
	@NotBlank
	@Size(min = 3, max = 20)
	private String prenom;
	@NotBlank
	@Size(min = 3, max = 20)
	private String sexe;
	
	private Date dateNaissance;
	
	private String specialite;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;
	
	/*@NotBlank
	private String matricule;
	
	@NotBlank 
	private String sexe;*/
	
	 private Set<String> role;
}
