package metier.dao;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Client;

@Local
public interface ClientLocal {
	
	public Client addClient(Client L);
	public Client getClient(int id);
	public List<Client> getAllClient();
	public Client updateClient(int id, String adresse, String email,String telephone, String nom,
								   String prenom);
	public void deleteClient(int id);

}
