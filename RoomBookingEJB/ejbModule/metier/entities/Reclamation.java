package metier.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity

public class Reclamation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_reclamation;
	private String Object;
	
	@ManyToOne()
	@JoinColumn(name="CODE_CLIENT_PAR")
	private Client client;

	
	public Reclamation() {
		super();
	}  
	
	
	public Reclamation(String object) {
		super();
		Object = object;
	}


	public Client getPersonne() {
		return client;
	}

	public void setPersonne(Client client) {
		this.client = client;
	}

	public int getId_reclamation() {
		return this.id_reclamation;
	}

	public void setId_reclamation(int id_reclamation) {
		this.id_reclamation = id_reclamation;
	}   
	public String getObject() {
		return this.Object;
	}

	public void setObject(String Object) {
		this.Object = Object;
	}
   
}
