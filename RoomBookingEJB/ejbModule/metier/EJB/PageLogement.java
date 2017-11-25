package metier.EJB;

import java.io.Serializable;
import java.util.List;

import metier.entities.Logement;

public class PageLogement implements Serializable{
	
	private List<Logement> logemens;
	private int pages;
	private int nomberLogement;
	private long totalLogement;
	private int total;
	
	
	
	public List<Logement> getLogemens() {
		return logemens;
	}
	public void setLogemens(List<Logement> logemens) {
		this.logemens = logemens;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getNomberLogement() {
		return nomberLogement;
	}
	public void setNomberLogement(int nomberLogement) {
		this.nomberLogement = nomberLogement;
	}
	public long getTotalLogement() {
		return totalLogement;
	}
	public void setTotalLogement(long totalLogement) {
		this.totalLogement = totalLogement;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	

}
