package metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;

import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
//@IdClass(Reservation_ID.class)
public class Reservation implements Serializable {
	
	private Date dateDebut;
	private Date dateFin;
	private double prix; // c'est le nombre de jours de réservation si la durée de cette dérniere n'est pas la meme que la disponiblité de logement
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_reservation;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="CODE_CLIENT", referencedColumnName="id_client")
	//@Id
	private Client client;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="CODE_LOGEMENT", referencedColumnName="id_logement")
	//@Id
	private Logement logement;
	
	

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Date datedebut,Date datefin, double prix, Client client, Logement logement) {
		super();
		this.dateDebut = datedebut;
		this.dateFin = datefin;
		this.prix = prix;
		this.client = client;
		this.logement = logement;
	}

	public Reservation(Date datedebut,Date datefin) {
		super();
		this.dateDebut = datedebut;
		this.dateFin = datefin;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateFin(Date datefin) {
		this.dateFin = datefin;
	}
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateDebut(Date datedebut) {
		this.dateDebut = datedebut;
	}

	public double getPrix() {
		return prix;
	}

	public void setDuree(double prix) {
		this.prix = prix;
	}

	public Client getClient() {
		return client;
	}

	@JsonSetter
	public void setClient(Client client) {
		this.client = client;
	}

	public Logement getLogement() {
		return logement;
	}

	@JsonSetter
	public void setLogement(Logement logement) {
		this.logement = logement;
	}
	
	
	

}
