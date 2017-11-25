package metier.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import metier.dao.ImageLocal;
import metier.entities.Image;

@Stateless(name="Im")
public class ImageEJBImpl implements ImageLocal {
	
	@PersistenceContext(unitName="RoomBookingEJB")
	private EntityManager em;

	@Override
	public Image addImage(Image I) {
		em.persist(I);
		return I;
	}

	@Override
	public Image updateImage(int id, String path) {
		Image I = em.find(Image.class, id);
		I.setPath(path);
		return I;
	}

	@Override
	public void deleteImage(int id) {
		Image I = em.find(Image.class, id);
		if(I != null) {
			em.remove(I);
		}
		
	}
	
	
	

}
