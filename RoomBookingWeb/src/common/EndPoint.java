package common;

public interface EndPoint {
	 String Get_Client="/clients";
	 String GET_Client_PATH_PARAMId ="/client/{id}";
	 String GET_Client_PATH_PARAM_LOGIN ="/client/login/{email}/{mdp}";
	 String POST_Client_PARAM = "/client";

	 
	 String Get_Logement="/logements";
	 String GET_Logement_PATH_PARAMId ="/logement/{id}";
	 String GET_Logement_PATH_PARAMIdHote =" /logementHote/{id}";
	 
	 String Get_Reservation="reservations";
	 String Get_Reservation_ID="reservation/{id}";
	 
	 
	 String Get_Disponibilite="/dispos";
	 String Get_Disponibilite_ID="/dispo/{id}";
	 String Get_Disponibilite_IDLogement="/dispos/logement/{id}";
	 
}
