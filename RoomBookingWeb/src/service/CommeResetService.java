package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.dao.CommeLocal;
import metier.entities.Commentaire;

@Stateless
@Path("/")
public class CommeResetService {
	
	@EJB
	private CommeLocal metier;

	
	@POST
	@Path("/commentaire") //JSON(application/json)
	@Produces(MediaType.APPLICATION_JSON)
	public Commentaire addCommentaire(Commentaire c) {
		return metier.addCommentaire(c);
	}

	
	@GET
	@Path("/commentaires/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Commentaire getCommentaire(@PathParam(value="id") int id) {
		return metier.getCommentaire(id);
	}

	
	@GET
	@Path("/commentaires")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Commentaire> getAllCommentaire() {
		return metier.getAllCommentaire();
	}
	
	@DELETE
	@Path("/commentaire/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletCommentaire(@PathParam(value="id") int id) {
		metier.deletCommentaire(id);
	}

}
