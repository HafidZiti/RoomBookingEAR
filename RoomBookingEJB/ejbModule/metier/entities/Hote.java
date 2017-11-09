package metier.entities;


import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("HO")
public class Hote extends Personne implements Serializable {

	
	private String RIP;
	@OneToMany(mappedBy="hote",fetch=FetchType.LAZY)
	private Collection<Logement> logements;

	public Hote() {
		super();
	} 
	
	
	public Hote(String nom, String prenom, String email, String telephone, String adresse, String rIP) {
		super(nom, prenom, email, telephone, adresse);
		RIP = rIP;
	}


	public String getRIP() {
		return this.RIP;
	}

	public void setRIP(String RIP) {
		this.RIP = RIP;
	}

	@JsonIgnore
	public Collection<Logement> getLogements() {
		return logements;
	}


	public void setLogements(Collection<Logement> logements) {
		this.logements = logements;
	}
	
	
	
	
   
}
