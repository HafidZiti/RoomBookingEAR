package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Logement implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_logement;
	private String description;
	private String adresse;
	@ManyToOne()
	@JoinColumn(name="CODE_CLIENT")
	private Client client;
	
	@OneToMany(mappedBy="logement",fetch = FetchType.EAGER)
	private Collection<Reservation> reservations;
	
	@OneToMany(mappedBy="logement")
	private Collection<Disponibilite> disponibilites;

	public Logement() {
		super();
	}   
	
	
	public Logement(String description, String adresse) {
		super();
		this.description = description;
		this.adresse = adresse;
	}

	
	public int getId_logement() {
		return this.id_logement;
	}

	public void setId_logement(int id_logement) {
		this.id_logement = id_logement;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}

	@JsonIgnore
	public Collection<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	@JsonIgnore
	public Collection<Disponibilite> getDisponibilites() {
		return disponibilites;
	}


	public void setDisponibilites(Collection<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}
	
	
   
}
