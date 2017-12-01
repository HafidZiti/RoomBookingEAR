package metier.dao;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import Beans.LogementBean;
import metier.EJB.LogementEJBImpl;
import metier.EJB.PageLogement;
import metier.entities.Disponibilite;
import metier.entities.Equipement;
import metier.entities.Logement;

@Local
public interface LogementLocal {
	public Logement addLogement(Logement L);
	public Logement getLogement(int id);
	public List<Logement> getAllLogement();
	public Logement updateLogement(int id, String adresse, String description);
	public void deleteLogement (int id);
	
	public PageLogement getPageLogement(int page, int size);
	
	public void add_equip_logement(int id, Set<Equipement> equips);
	
	public Logement addLogementBean(LogementBean lb);

}
