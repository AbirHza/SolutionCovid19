package tn.esprit.pfe.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Table(	name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames="email")
})

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Utilisateur  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 20)
	private String matricule;
	private String nom;
	private String prenom;
	private String email;
	private String sexe;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Enumerated(EnumType.STRING)
	private Specialite specialite;
	private String username;
	private String password;
	@JsonIgnore
    private String resetToken;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", 
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="medecin")
	private Set<Patient> listPatient;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="medecin")
	private List<Reponse> reponses;


	public Utilisateur(String matricule, String prenom, String nom, String email, String password, String sexe){
		
		this.matricule=matricule;
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		this.password=password;
		this.sexe=sexe;
		
	}
	public Utilisateur(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public Utilisateur(String matricule, String nom, String prenom, String email, String sexe, String username,
			String password) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.sexe = sexe;
		this.username = username;
		this.password = password;
	}
	
}
