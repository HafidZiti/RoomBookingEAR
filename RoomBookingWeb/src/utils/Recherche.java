package utils;

import java.util.Date;

public class Recherche {

	private String villeRecherche ;
    private Date dateDebut ;
	private Date dateFin  ;
	private int nbrVoyageur;
	public String getVilleRecherche() {
		return villeRecherche;
	}
	public void setVilleRecherche(String ville) {
		this.villeRecherche = ville;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getNbrVoyageur() {
		return nbrVoyageur;
	}
	public void setNbrVoyageur(int nbrVoyageur) {
		this.nbrVoyageur = nbrVoyageur;
	}  

	
}
