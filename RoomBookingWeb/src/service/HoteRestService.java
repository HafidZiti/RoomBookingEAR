package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.dao.HoteLocal;
import metier.entities.Hote;

@Stateless
@Path("/")
public class HoteRestService {
	
	@EJB
	private HoteLocal metier;

	@POST
	@Path("/hote") //JSON(application/json)
	@Produces(MediaType.APPLICATION_JSON)
	public Hote addHote(Hote L) {
		return metier.addHote(L);
	}

	@GET
	@Path("/hote/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hote getHote(@PathParam(value="id") int id) {
		return metier.getHote(id);
	}

	@GET
	@Path("/hotes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hote> getAllHote() {
		return metier.getAllHote();
	}

	@PUT
	@Path("/hote/update")
	@Produces(MediaType.APPLICATION_JSON) //x-www-form-urlencoded
	public Hote updateHote(@FormParam(value="id")int id, 
							@FormParam(value="adresse")String adresse, 
							@FormParam(value="email")String email, 
							@FormParam(value="telephone")String telephone, 
							@FormParam(value="nom")String nom, 
							@FormParam(value="prenom")String prenom,
							@FormParam(value="rip")String rip) {
		return metier.updateHote(id, adresse, email, telephone, nom, prenom, rip);
	}

	@DELETE
	@Path("/hote/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteHote(@PathParam(value="id") int id) {
		metier.deleteHote(id);
	}

}
