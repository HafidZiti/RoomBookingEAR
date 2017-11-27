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
	
	private Date date;
	private int duree; // c'est le nombre de jours de réservation si la durée de cette dérniere n'est pas la meme que la disponiblité de logement
	
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

	public Reservation(Date date, int duree, Client client, Logement logement) {
		super();
		this.date = date;
		this.duree = duree;
		this.client = client;
		this.logement = logement;
	}

	public Reservation(Date date, int duree) {
		super();
		this.date = date;
		this.duree = duree;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
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
