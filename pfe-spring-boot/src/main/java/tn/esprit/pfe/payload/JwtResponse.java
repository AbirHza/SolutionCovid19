package tn.esprit.pfe.payload;

import java.util.Date;
import java.util.List;

public class JwtResponse {
	
	private String token;
	private String type = "Bearer";
	private Long id;
	private String matricule;
	private String nom;
	private String prenom;
	private String sexe;
	private Date dateNaissance;
	private List<String> specialite;
	private String username;
	private String email;
	private List<String> roles;
	
	public JwtResponse(String accessToken, long id, String matricule, String username, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.matricule=matricule;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	
	public JwtResponse(String accessToken, long id, String matricule, String nom, String prenom, String sexe, String username, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.matricule=matricule;
		this.nom=nom;
		this.prenom=prenom;
		this.sexe=sexe;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	
	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public List<String> getSpecialite() {
		return specialite;
	}

	public void setSpecialite(List<String> specialite) {
		this.specialite = specialite;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
}
