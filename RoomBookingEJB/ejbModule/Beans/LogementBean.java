package Beans;


import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonSetter;

import metier.entities.Equipement;
import metier.entities.Image;
import metier.entities.Logement;

@XmlRootElement
@XmlTransient
public class LogementBean implements Serializable {
	
	private Logement logement;
	private Set<Equipement> equipements;
	private Set<Image>images;
	
	public LogementBean() {
		super();
	
	}

	public LogementBean(Logement logement, Set<Equipement> equipements, Set<Image> images) {
		super();
		this.logement = logement;
		this.equipements = equipements;
		this.images = images;
	}

	public Set<Equipement> getEquipements() {
		return equipements;
	}

	@JsonSetter
	public void setEquipements(Set<Equipement> equipements) {
		this.equipements = equipements;
	}

	public Set<Image> getImages() {
		return images;
	}
	@JsonSetter
	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Logement getLogement() {
		return logement;
	}
    @JsonSetter
	public void setLogement(Logement logement) {
		this.logement = logement;
	}

}
