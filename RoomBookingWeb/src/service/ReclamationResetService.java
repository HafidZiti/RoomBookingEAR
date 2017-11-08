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

import metier.dao.ReclamationLocal;
import metier.entities.Reclamation;

@Stateless
@Path("/")
public class ReclamationResetService {
	
	@EJB
	private ReclamationLocal metier;

	
	@POST
	@Path("/reclamation") //JSON(application/json)
	@Produces(MediaType.APPLICATION_JSON)
	public Reclamation addReclamation(Reclamation R) {
		return metier.addReclamation(R);
	}

	
	@GET
	@Path("/reclamation/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reclamation getReclamation(@PathParam(value="id") int id) {
		return metier.getReclamation(id);
	}

	
	@GET
	@Path("/reclamations")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reclamation> getAllReclamation() {
		return metier.getAllReclamation();
	}

	@DELETE
	@Path("/reclamation/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteReclamation(@PathParam(value="id") int id) {
		metier.deleteReclamation(id);
	}

}
