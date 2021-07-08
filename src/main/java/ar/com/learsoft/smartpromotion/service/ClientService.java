package ar.com.learsoft.smartpromotion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.learsoft.smartpromotion.model.Client;
import ar.com.learsoft.smartpromotion.repository.ClientRepository;

@Component("clientService")
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client updateClient(Client client) {
		Client currentClient = this.findClient(client.getId());
		currentClient.setName(client.getName());
		currentClient.setLastname(client.getLastname());
		return clientRepository.save(currentClient);
	}
	
	public Client findClient(Integer idClient) {
		return clientRepository.findById(idClient).get();
	}

	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

	public List<Client> findAllClients() {
		return clientRepository.findAll();
	}

	public String deleteClient(Integer id) {
		clientRepository.deleteById(id);
		return "Client Deleted  " + id;
	}
	
}
