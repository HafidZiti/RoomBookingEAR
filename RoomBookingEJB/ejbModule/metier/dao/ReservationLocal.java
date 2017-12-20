package metier.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import metier.entities.Reservation;

@Local

public interface ReservationLocal {
	
	public Reservation addReservation(Reservation R);
	public Reservation getReservation(int id);
	public List<Reservation> getAllReservation();
	public Reservation updateReservation(int id,int duree);
	public void deleteReservation(int id);
	Reservation updateReservation(int id, Date datefin);
	

}
