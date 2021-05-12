package tn.esprit.pfe.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Ordonnance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long num_ORD;
	private Date date_ORD;
	@ManyToMany(cascade=CascadeType.ALL ,fetch=FetchType.EAGER)
	private List<Medicament> medicaments;
	private int nmbr_fois_med;
	@Enumerated(EnumType.STRING)
	private Quand quant_med;
	private String observation;
	@ManyToOne
	private Patient patient;
}
