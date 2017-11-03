package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.jms.JMSSessionMode;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PERSONNE",discriminatorType=DiscriminatorType.STRING,length=2)

public class Personne implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_client;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String adresse;
	
	@OneToMany(mappedBy="personne")
	private Collection<Reclamation> reclamations;
	
	@OneToMany(mappedBy="personne_par")
	private Collection<Commentaire> commentaires_donne;
	
	@OneToMany(mappedBy="personne_vers")
	private Collection<Commentaire> commentaires_subi;
	
	
	public Personne() {
		super();
	}   
	
	
	public Personne(String nom, String prenom, String email, String telephone, String adresse) {
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


	public Collection<Reclamation> getReclamations() {
		return reclamations;
	}


	public void setReclamations(Collection<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}


	public Collection<Commentaire> getCommentaires_donne() {
		return commentaires_donne;
	}


	public void setCommentaires_donne(Collection<Commentaire> commentaires_donne) {
		this.commentaires_donne = commentaires_donne;
	}

	public Collection<Commentaire> getCommentaires_subi() {
		return commentaires_subi;
	}


	public void setCommentaires_subi(Collection<Commentaire> commentaires_subi) {
		this.commentaires_subi = commentaires_subi;
	}
		
   
}
