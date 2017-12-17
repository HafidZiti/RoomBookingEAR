package metier.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Client implements Serializable {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_client;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String adresse;
	private String mdp;
	private Boolean isHote;
	
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection<Reservation> reservations;
	
	@OneToMany(mappedBy="client")
	private Collection<Reclamation> reclamations;
	
	@OneToMany(mappedBy="client_par")
	private Collection<Commentaire> commentaires_donne;
	
	@OneToMany(mappedBy="client_vers")
	private Collection<Commentaire> commentaires_subi;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Logement> logements;

	
	public Client() {
		super();
	}   
	
	
	public Client(String nom, String prenom, String email, String telephone, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.adresse= adresse;
	}


	public int getId_client() {
		return this.id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	@JsonIgnore
	public Collection<Reclamation> getReclamations() {
		return reclamations;
	}


	public void setReclamations(Collection<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}


	@JsonIgnore
	public Collection<Commentaire> getCommentaires_donne() {
		return commentaires_donne;
	}


	public void setCommentaires_donne(Collection<Commentaire> commentaires_donne) {
		this.commentaires_donne = commentaires_donne;
	}

	@JsonIgnore
	public Collection<Commentaire> getCommentaires_subi() {
		return commentaires_subi;
	}


	public void setCommentaires_subi(Collection<Commentaire> commentaires_subi) {
		this.commentaires_subi = commentaires_subi;
	}
	

	@JsonIgnore
	public Collection<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	@JsonIgnore
	public Collection<Logement> getLogements() {
		return logements;
	}


	public void setLogements(Collection<Logement> logements) {
		this.logements = logements;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public Boolean getIsHote() {
		return isHote;
	}


	public void setIsHote(Boolean isHote) {
		this.isHote = isHote;
	}


	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", telephone=" + telephone + ", adresse=" + adresse + ", mdp=" + mdp + ", isHote=" + isHote
				+ ", reservations=" + reservations + ", reclamations=" + reclamations + ", commentaires_donne="
				+ commentaires_donne + ", commentaires_subi=" + commentaires_subi + ", logements=" + logements + "]";
	}
	
	
   
}
