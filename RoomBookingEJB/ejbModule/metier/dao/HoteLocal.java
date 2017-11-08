package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Hote;

@Local
public interface HoteLocal {
	public Hote addHote(Hote L);
	public Hote getHote(int id);
	public List<Hote> getAllHote();
	public Hote updateHote(int id, String adresse, String email,String telephone, String nom,
								   String prenom, String rip);
	public void deleteHote(int id);
}
