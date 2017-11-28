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
	
	@ManyToMany(mappedBy="equipements",cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
	private Set<Logement> logements;

	public Equipement() {
		super();
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
	public Set<Logement> getLogements() {
		return this.logements;
	}

	//@JsonSetter
	public void setLogements(Set<Logement> logements) {
		this.logements = logements;
	}

	@Override
	public String toString() {
		return "Equipement [id_equip=" + id_equip + ", nom_equipement=" + nom_equipement + "]";
	}
	
	
	
	

}
