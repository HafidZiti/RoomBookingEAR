package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Reclamation;

@Local
public interface ReclamationLocal {
	
	public Reclamation addReclamation(Reclamation R);
	public Reclamation getReclamation(int id);
	public List<Reclamation> getAllReclamation();
	public void deleteReclamation(int id);

}
