package metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@IdClass(Reservation_ID.class)
public class Reservation implements Serializable {
	
	private Date date;
	private int duree; // c'est le nombre de jours de r�servation si la dur�e de cette d�rniere n'est pas la meme que la disponiblit� de logement
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="CODE_CLIENT", referencedColumnName="ID")
	@Id
	private Client client;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="CODE_LOGEMENT", referencedColumnName="ID")
	@Id
	private Logement logement;
	
	

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
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

	public void setClient(Client client) {
		this.client = client;
	}

	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}
	
	
	

}
