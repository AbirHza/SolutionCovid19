package tn.esprit.pfe.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Medicament implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long code_Med;
	private String nom_Med;
	private double dose_Med;
	private String presentation;
	@ManyToMany(mappedBy="medicaments", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Ordonnance> ordonnances;
}
