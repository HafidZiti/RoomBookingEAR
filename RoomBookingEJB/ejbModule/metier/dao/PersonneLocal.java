package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Personne;

@Local
public interface PersonneLocal {
	public Personne addPersonne(Personne L);
	public Personne getPersonne(int id);
	public List<Personne> getAllPersonne();
	public Personne updateLogement(int id, String adresse, String email,String telephone, String nom,
								   String prenom, String rip);
	public void deletePersonne(int id);
}
