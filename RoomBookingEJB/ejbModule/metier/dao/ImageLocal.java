package metier.dao;

import metier.entities.Image;

public interface ImageLocal {
	
	public Image addImage(Image I);
	public Image updateImage(int id, String path);
	public void deleteImage(int id);

}
