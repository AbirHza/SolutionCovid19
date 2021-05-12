package tn.esprit.pfe.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long numSecuriteSociale;
	private String sexe;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Temporal(TemporalType.TIME)
	private Date dateEntree;
	private Long telephonePortable;
	private String email;
	private String ville;
	@ManyToOne
	private Utilisateur medecin;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="patient")
	private Set<Ordonnance> ordonnances;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="patient")
	private Set<Radiographie> radiographies;
}
