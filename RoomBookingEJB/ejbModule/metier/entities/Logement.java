package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;


@Entity

public class Logement implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_logement;
	private String titre;
	private int nbt_voyageurs;
	private int nbr_chamber;
	private int nbr_salle_bain;
	private double prix;
	private String ville;
	private int code_postal;
	private String adresse;
	private String description;
	
	@ManyToOne()
	@JoinColumn(name="CODE_CLIENT")
	private Client client;
	
	@OneToMany(mappedBy="logement",fetch = FetchType.LAZY)
	private Collection<Reservation> reservations;
	
	@OneToMany(mappedBy="logement")
	private Collection<Disponibilite> disponibilites;
	
	@OneToMany(mappedBy="logement",fetch = FetchType.LAZY)
	private Collection<Image> images;
	
//	@OneToMany(mappedBy="logement",fetch = FetchType.LAZY)
//private Collection<Logement_equipement> logement_equipements;
	  @ManyToMany(cascade = CascadeType.PERSIST)
	  @JoinTable(name="logement_equipement02",
	      joinColumns=@JoinColumn(name="id_log"),
	      inverseJoinColumns=@JoinColumn(name="id_equip"))
	  
	  private List<Equipement> equipements;
	  
	

	public Logement() {
		super();
	}   
	
	public Logement(int id_logement, String titre, int nbt_voyageurs, int nbr_chamber, int nbr_salle_bain, double prix,
			String ville, int code_postal, String adresse, String description) {
		super();
		this.id_logement = id_logement;
		this.titre = titre;
		this.nbt_voyageurs = nbt_voyageurs;
		this.nbr_chamber = nbr_chamber;
		this.nbr_salle_bain = nbr_salle_bain;
		this.prix = prix;
		this.ville = ville;
		this.code_postal = code_postal;
		this.adresse = adresse;
		this.description = description;
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


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getNbt_voya_adultes() {
		return nbt_voyageurs;
	}


	public void setNbt_voya_adultes(int nbt_voya_adultes) {
		this.nbt_voyageurs = nbt_voya_adultes;
	}


	public int getNbt_voya_enfants() {
		return nbt_voyageurs;
	}


	public void setNbt_voya_enfants(int nbt_voya_enfants) {
		this.nbt_voyageurs = nbt_voya_enfants;
	}


	public int getNbr_chamber() {
		return nbr_chamber;
	}


	public void setNbr_chamber(int nbr_chamber) {
		this.nbr_chamber = nbr_chamber;
	}


	public int getNbr_salle_bain() {
		return nbr_salle_bain;
	}


	public void setNbr_salle_bain(int nbr_salle_bain) {
		this.nbr_salle_bain = nbr_salle_bain;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public int getCode_postal() {
		return code_postal;
	}


	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public int getNbt_voyageurs() {
		return nbt_voyageurs;
	}


	public void setNbt_voyageurs(int nbt_voyageurs) {
		this.nbt_voyageurs = nbt_voyageurs;
	}

	public Collection<Image> getImages() {
		return images;
	}

	@JsonSetter
	public void setImages(Collection<Image> images) {
		this.images = images;
	}

	public List<Equipement> getLogement_equipements() {
		return this.equipements;
	}

	@JsonSetter
	public void setLogement_equipements(List<Equipement> logement_equipements) {
		this.equipements = logement_equipements;
	}
}
