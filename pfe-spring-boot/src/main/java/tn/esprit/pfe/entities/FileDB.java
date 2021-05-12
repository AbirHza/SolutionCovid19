package tn.esprit.pfe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "files")
@Data @NoArgsConstructor @AllArgsConstructor
public class FileDB {
	@Id
	@GeneratedValue(generator ="uuid")
	@GenericGenerator(name ="uuid", strategy= "uuid2")
	@Column(length = 100)
	@NotNull
	private String id;
	private String nom;
	private String type;
	@Lob
	//@Column(length=1000000)
	private byte[] data;
	@ManyToOne
	private Radiographie radiographie;

	public FileDB(String nom, String type, byte[] data) {
		this.nom = nom;
		this.type = type;
		this.data = data;
	}
}
