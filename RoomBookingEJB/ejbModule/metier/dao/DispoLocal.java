package metier.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import metier.entities.Disponibilite;

@Local
public interface DispoLocal {
	
	public Disponibilite addDisponibilite(Disponibilite d);
	public Disponibilite getDisponibilite(int id);
	public List<Disponibilite> getAllDisponibilite();
	public Disponibilite updateDisponibilite(int id, Date date_debut, Date date_fin);
	public void DeleteDisponibilite(int id);

}
