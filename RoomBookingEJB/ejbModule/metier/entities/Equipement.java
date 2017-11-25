package metier.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Equipement implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_equip;
	private String nom_equipement;
	
	@OneToMany(mappedBy="equipement",fetch = FetchType.LAZY)
	private Collection<Logement_equipement> logement_equipements;

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

	public Collection<Logement_equipement> getLogement_equipements() {
		return logement_equipements;
	}

	public void setLogement_equipements(Collection<Logement_equipement> logement_equipements) {
		this.logement_equipements = logement_equipements;
	}
	
	

}
