package metier.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
public class Equipement implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_equip;
	private String nom_equipement;
	
//	@OneToMany(mappedBy="equipement",fetch = FetchType.LAZY)
//	private Collection<Logement_equipement> logement_equipements;
	
	@ManyToMany(mappedBy="equipements", cascade =  CascadeType.PERSIST)
	private Set<Logement> logements;

	public Equipement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipement(int id_equip, String nom_equipement) {
		super();
		this.id_equip = id_equip;
		this.nom_equipement = nom_equipement;
	}

	public int getId_equip() {
		return id_equip;
	}

	public void setId_equip(int id_equip) {
		this.id_equip = id_equip;
	}

	public String getNom_equipement() {
		return nom_equipement;
	}

	public void setNom_equipement(String nom_equipement) {
		this.nom_equipement = nom_equipement;
	}

	@JsonIgnore
	public Set<Logement> getLogement_equipements() {
		return this.logements;
	}

	@JsonSetter
	public void setLogement_equipements(Set<Logement> logement_equipements) {
		this.logements = logement_equipements;
	}
	
	

}
