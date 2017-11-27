package metier.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@IdClass(Logement_Equipement_ID.class)
public class Logement_equipement implements Serializable{
	
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="CODE_EQUIPEMENT", referencedColumnName="ID")
	@Id
	private Equipement equipement;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="CODE_LOGEMENT", referencedColumnName="ID")
	@Id
	private Logement logement;

	public Logement_equipement() {
		super();
	}
	
	

	@JsonIgnore
	public Equipement getEquipement() {
		return equipement;
	}

	@JsonSetter
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	
	@JsonIgnore
	public Logement getLogement() {
		return logement;
	}

	@JsonSetter
	public void setLogement(Logement logement) {
		this.logement = logement;
	}
	
	

}
