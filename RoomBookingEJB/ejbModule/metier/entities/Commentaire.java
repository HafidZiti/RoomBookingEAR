package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

@Entity

public class Commentaire implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_commentaire;
	private String contenu;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLIENT_PAR")
	private Client client_par;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLIENT_VERS")
	private Client client_vers;
	
	

	public Commentaire() {
		super();
	}   
	public int getId_commentaire() {
		return this.id_commentaire;
	}

	public void setId_commentaire(int id_commentaire) {
		this.id_commentaire = id_commentaire;
	}   
	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
   
}
