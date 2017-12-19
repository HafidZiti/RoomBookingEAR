package metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity()

public class Disponibilite implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_disponibilite;
	private Date date_debut;
	private Date date_fin;
	
	@ManyToOne
	@JoinColumn(name="CODE_LOGEMENT")
	private Logement logement;

	public Disponibilite() {
		super();
	}   
	
	
	public Disponibilite(Date date_debut, Date date_fin) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public Disponibilite(Date date_debut, Date date_fin , Logement l) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.logement = l ;
	}


	public int getId_disponibilite() {
		return this.id_disponibilite;
	}

	public void setId_disponibilite(int id_disponibilite) {
		this.id_disponibilite = id_disponibilite;
	}   
	public Date getDate_debut() {
		return this.date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}   
	public Date getDate_fin() {
		return this.date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}


	public Logement getLogement() {
		return logement;
	}


	public void setLogement(Logement logement) {
		this.logement = logement;
	}
	
	
   
}
