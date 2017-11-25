package service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.dao.ImageLocal;
import metier.entities.Image;

@Stateless
@Path("/")
public class ImageRestService {
	
	@EJB
	private ImageLocal metier;

	@POST
	@Path("/image") //JSON(application/json)
	@Produces(MediaType.APPLICATION_JSON)
	public Image addImage(Image I) {
		return metier.addImage(I);
	}

	
	@PUT
	@Path("/image/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Image updateImage(@FormParam(value="id")int id,
							 @FormParam(value="path")String path) {
		return metier.updateImage(id, path);
	}

	
	@DELETE
	@Path("/image/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteImage(int id) {
		metier.deleteImage(id);
	}
	

}
