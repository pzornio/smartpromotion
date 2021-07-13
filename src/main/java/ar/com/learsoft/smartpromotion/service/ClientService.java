package ar.com.learsoft.smartpromotion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.learsoft.smartpromotion.dto.DTOClient;
import ar.com.learsoft.smartpromotion.model.Client;
import ar.com.learsoft.smartpromotion.repository.ClientRepository;

@Component("clientService")
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client updateClient(DTOClient dtoClient) {
		Client currentClient = this.findClient(dtoClient.getId());
		currentClient.setName(dtoClient.getName());
		currentClient.setLastname(dtoClient.getLastname());
		return clientRepository.save(currentClient);
	}
	
	public Client findClient(Integer idClient) {
		return clientRepository.findById(idClient).get();
	}

	public Client createClient(DTOClient dtoClient) {
		Client client =dtoClient.buildClient();
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
