package metier.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Logement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@JoinColumn(name = "CODE_CLIENT")
	private Client client;

	@OneToMany(mappedBy = "logement", fetch = FetchType.LAZY)
	private Collection<Reservation> reservations;

	@OneToMany(mappedBy = "logement")
	private Collection<Disponibilite> disponibilites;

	@OneToMany(mappedBy = "logement", fetch = FetchType.EAGER)
	private Collection<Image> images;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER) // LAZY il va pas charger la liste des
																		// equipements
	
	@JoinTable(name = "logement_equipement02", joinColumns = @JoinColumn(name = "id_logement"), 
												inverseJoinColumns = @JoinColumn(name = "id_equip"))

	private Set<Equipement> equipements; // c'est mieux d'utiliser Set ou lieu de liste vu que JPA gen�re Automatiqement
											// Primary Key of Join Table et c'est pas le cas avec List

	public Logement() {
		super();
	}

	public Logement(int idLogement, String titre, int nbtVoyageurs, int nbrChamber, int nbrSalleBbain, double prix,
			String ville, int codePostal, String adresse, String description) {
		super();
		this.id_logement = idLogement;
		this.titre = titre;
		this.nbt_voyageurs = nbtVoyageurs;
		this.nbr_chamber = nbrChamber;
		this.nbr_salle_bain = nbrSalleBbain;
		this.prix = prix;
		this.ville = ville;
		this.code_postal = codePostal;
		this.adresse = adresse;
		this.description = description;
	}

	public int getId_logement() {
		return this.id_logement;
	}

	public void setId_logement(int idLogement) {
		this.id_logement = idLogement;
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

	public int getNbr_chamber() {
		return nbr_chamber;
	}

	public void setNbr_chamber(int nbrChamber) {
		this.nbr_chamber = nbrChamber;
	}

	public int getNbr_salle_bain() {
		return nbr_salle_bain;
	}

	public void setNbr_salle_bain(int nbrSalleBSain) {
		this.nbr_salle_bain = nbrSalleBSain;
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

	public void setCode_postal(int codePostal) {
		this.code_postal = codePostal;
	}

	public int getNbt_voyageurs() {
		return nbt_voyageurs;
	}

	public void setNbt_voyageurs(int nbtVoyageurs) {
		this.nbt_voyageurs = nbtVoyageurs;
	}

	public Collection<Image> getImages() {
		return images;
	}

	public void setImages(Collection<Image> images) {
		this.images = images;
	}

	public Set<Equipement> getEquipements() {
		return this.equipements;
	}

	public void setEquipements(Set<Equipement> equipements) {
		this.equipements = equipements;
	}

	@Override
	public String toString() {
		return "Logement [id_logement=" + this.id_logement +"]";
	}
	
	
}
