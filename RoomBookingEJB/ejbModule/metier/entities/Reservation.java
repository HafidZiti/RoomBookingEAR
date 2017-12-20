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
	
	private Date date_Debut;
	private Date date_Fin;
	private int prix_duree; 
	
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
	
	

	@Override
	public String toString() {
		return "Reservation [date_Debut=" + date_Debut + ", date_Fin=" + date_Fin + ", prix_duree=" + prix_duree
				+ ", id_reservation=" + id_reservation + ", client=" + client + ", logement=" + logement + "]";
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Date date_Debut,Date date_Fin, int prix_duree, Client client, Logement logement) {
		super();
		this.date_Debut = date_Debut;
		this.date_Fin = date_Fin;
		this.prix_duree = prix_duree;
		this.client = client;
		this.logement = logement;
	}

	public Reservation(Date date_Debut,Date date_Fin) {
		super();
		this.date_Debut = date_Debut;
		this.date_Fin = date_Fin;
	}


	

	public Date getDate_Debut() {
		return date_Debut;
	}

	public void setDate_Debut(Date date_Debut) {
		this.date_Debut = date_Debut;
	}

	public Date getDate_Fin() {
		return date_Fin;
	}

	public void setDate_Fin(Date date_Fin) {
		this.date_Fin = date_Fin;
	}

	

	public int getPrix_duree() {
		return prix_duree;
	}

	public void setPrix_duree(int prix_duree) {
		this.prix_duree = prix_duree;
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
