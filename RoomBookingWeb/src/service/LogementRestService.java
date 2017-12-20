package service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import Beans.LogementBean;
import metier.EJB.PageLogement;
import metier.dao.LogementLocal;
import metier.entities.Equipement;
import metier.entities.Logement;
import utils.Recherche;

@Stateless
@Path("/")
public class LogementRestService {

	@EJB
	private LogementLocal metier;

	@POST
	@Path("/logement_bean")
	@Produces(MediaType.APPLICATION_JSON)
	public Logement addLogementBean(LogementBean lb) {
		return metier.addLogementBean(lb);
	}

	@GET
	@Path("/pagelogement/{page}/{size}")
	@Produces(MediaType.APPLICATION_JSON)
	public PageLogement getPageLogement(@PathParam(value = "page") int page, @PathParam(value = "size") int size) {
		return metier.getPageLogement(page, size);
	}
	@GET
	@Path("/pagelogementRecherche/{page}/{size}/{rechercheJSON}/")
	@Produces(MediaType.APPLICATION_JSON)
	public PageLogement getPageLogementRecherche(@PathParam(value = "page") int page,
			@PathParam(value = "size") int size, @PathParam(value = "rechercheJSON") String rechercheJSON) {
		System.out.println(rechercheJSON);
		Recherche recherche = new Recherche() ;
		ObjectMapper jackson = new ObjectMapper();
		try {
			 recherche = jackson.readValue(new ByteArrayInputStream(rechercheJSON.getBytes()), Recherche.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return metier.getPageLogement(page, size, recherche.getVilleRecherche(), recherche.getDateDebut(), recherche.getDateFin(), recherche.getNbrVoyageur());
	}
	

	@POST
	@Path("/logement")
	@Produces(MediaType.APPLICATION_JSON)
	public Logement addLogement(Logement L) {
		return metier.addLogement(L);
	}

	@POST
	@Path("/log_equip/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addequip_logement(@PathParam(value = "id") int id, Set<Equipement> equips) {

		// equips.forEach((e) ->
		// {System.out.println("Afficher"+e.getId_equip());});
		// System.out.println("Affiche 02 "+ id);
		// l.forEach((i) ->
		// {System.out.println("Afficher"+i.getId_logement());});
		// System.out.println("afficher" + l.getId_logement());
		metier.add_equip_logement(id, equips);
	}

	@GET
	@Path("/logement/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Logement getLogement(@PathParam(value = "id") int id) {
		return metier.getLogement(id);
	}

	@GET
	@Path("/logementHote/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Logement> getLogementHote(@PathParam(value = "id") int id) {
		return metier.getLogementHote(id);
	}

	@GET
	@Path("/logements")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Logement> getAllLogement() {
		return metier.getAllLogement();
	}

	@PUT
	@Path("/logement/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Logement updateLogement(@FormParam(value = "id") int id, @FormParam(value = "adresse") String adresse,
			@FormParam(value = "description") String description) {
		return metier.updateLogement(id, adresse, description);
	}

	@DELETE
	@Path("/logement/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteLogement(@PathParam(value = "id") int id) {
		metier.deleteLogement(id);
	}

}
