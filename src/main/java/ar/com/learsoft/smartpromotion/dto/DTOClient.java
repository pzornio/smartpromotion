package ar.com.learsoft.smartpromotion.dto;

import ar.com.learsoft.smartpromotion.model.Client;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class DTOClient extends DTOGeneric{
	private Integer id;
	private String name;
	private String lastname;
	
	
	public void setClient(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.lastname = client.getLastname();	
	}


	public Client buildClient() {
		Client client = new Client();
		client.setId(this.id);
		client.setLastname(this.lastname);
		client.setName(this.name);
		return client;
	}
}
