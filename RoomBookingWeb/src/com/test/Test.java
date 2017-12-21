package com.test;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.BeforeClass;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;

import common.EndPoint;
import metier.entities.Client;
import metier.entities.Logement;
import metier.entities.Reservation;


public class Test {
	/**
	 * methode pour tester le setup du service web
	 */

	@BeforeClass   
	public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/RoomBookingWeb/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

}
	
/*********************************************Client test ************************************************************************************/
	
	/**
	 * methode pour tester le renvoi de tous les clients
	 */
	@org.junit.Test
    public void validateClient() {
		RestAssured.given().get(EndPoint.Get_Client).then().statusCode(200).log().all();
}
	
	/**
	 * methode pour tester validate client
	 * pathParam: id_client
	 */
	@org.junit.Test
	public void validateClientId() {
		RequestSpecification r= new RestAssuredConfiguration().getRequestSpecification();
		r.pathParam("id", 9).log().all();
		RestAssured.given().spec(r).get(EndPoint.GET_Client_PATH_PARAMId).then().statusCode(200).log().all();
		
	}
	
	/**
	 * methode pour tester l'indetification du client
	 * pathParam: email et mot de passe 
	 */
	@org.junit.Test
	public void validateClientLogin() {
		RequestSpecification r= new RestAssuredConfiguration().getRequestSpecification();
		r.pathParam("email","azzabi08@gmail.com").log().all();
		r.pathParam("mdp","MTIz").log().all();
		RestAssured.given().spec(r).get(EndPoint.GET_Client_PATH_PARAM_LOGIN).then().statusCode(200).log().all();
	}
	
	
	/**
	 * methode qui teste l'ajout d'un nouveau client
	 */

	 @org.junit.Test
	 public void postAddClient() {
		 Client c= new Client("sss", "ddd", "b@b", "123", "jhfgjehg");
		  Gson gson = new GsonBuilder().create();
		 String cl = gson.toJson(c);
		  Response res = RestAssured.given().contentType("application/json").body(cl).when().post("/client");
		  Assert.assertEquals(res.statusCode(), HttpStatus.SC_OK);
	 }
	 
	 
	 
	 
	 
	 
	 
/************************************************* Logement test *****************************************************************/
		
		/**
		 * methode pour tester le renvoi de tous les logements
		 */
		@org.junit.Test
	    public void validateLogement() {
			RestAssured.given().get(EndPoint.Get_Logement).then().statusCode(200).log().all();
	}
		
		/**
		 * methode pour tester validate logement
		 * pathParam: id_logement
		 */	
		@org.junit.Test
		public void validateLogementID() {
			RequestSpecification r= new RestAssuredConfiguration().getRequestSpecification();
			r.pathParam("id",2).log().all();
			
			RestAssured.given().spec(r).get(EndPoint.GET_Logement_PATH_PARAMId).then().statusCode(200).log().all();
		}
		
		
		/**
		 * methode pour tester le renvoi d'une liste des logements d'un hote precis 
		 * pathParam: id_hote
		 */
		@org.junit.Test
		public void validateLogementIdHote() {
			RequestSpecification r= new RestAssuredConfiguration().getRequestSpecification();
			r.pathParam("id",2).log().all();
			
			RestAssured.given().spec(r).get(EndPoint.GET_Logement_PATH_PARAMIdHote).then().statusCode(200).log().all();
		}
		
		
/*******************************************************Rservation test*******************************************************************************/		
		
		/**
		 * methode pour tester le renvoi de tous les reservations
		 */
		
		@org.junit.Test
	    public void validateReservation() {
			RestAssured.given().get(EndPoint.Get_Reservation).then().statusCode(200).log().all();
	}
		
		/**
		 * methode pour tester validate reservation
		 * pathParam: id_reservation
		 */

		@org.junit.Test
		public void validateReservationID() {
			RequestSpecification r= new RestAssuredConfiguration().getRequestSpecification();
			r.pathParam("id",15).log().all();
			
			RestAssured.given().spec(r).get(EndPoint.Get_Reservation_ID).then().statusCode(200).log().all();
		}
		
		
		

	 
/*******************************************************disponibilite test*******************************************************************************/		
		
		/**
		 * methode pour tester le renvoi de tous les disponibilites des logements
		 */
		@org.junit.Test
	    public void validateDisponibilite() {
			RestAssured.given().get(EndPoint.Get_Disponibilite).then().statusCode(200).log().all();
	}
		
		/**
		 * methode pour tester validate disponibilite
		 * pathParam: id_disponibilite
		 */

		@org.junit.Test
		public void validateDisponibiliteID() {
			RequestSpecification r= new RestAssuredConfiguration().getRequestSpecification();
			r.pathParam("id",10).log().all();
			
			RestAssured.given().spec(r).get(EndPoint.Get_Disponibilite_ID).then().statusCode(200).log().all();
		}
		
		
		/**
		 * methode pour tester le renvoi de la liste de disponibilite d'un logement precis 
		 * pathParam: id_logement
		 */
		@org.junit.Test
		public void validateDisponibiliteIDLogement() {
			RequestSpecification r= new RestAssuredConfiguration().getRequestSpecification();
			r.pathParam("id",3).log().all();
			
			RestAssured.given().spec(r).get(EndPoint.Get_Disponibilite_IDLogement).then().statusCode(200).log().all();
		}
}
