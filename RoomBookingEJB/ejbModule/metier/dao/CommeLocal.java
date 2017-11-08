package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Commentaire;

@Local
public interface CommeLocal {
	
	public Commentaire addCommentaire(Commentaire c);
	public Commentaire getCommentaire (int id);
	public List<Commentaire> getAllCommentaire();
	public void deletCommentaire(int id);

}
