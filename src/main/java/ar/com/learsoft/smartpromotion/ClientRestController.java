package ar.com.learsoft.smartpromotion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.learsoft.smartpromotion.model.Client;
import ar.com.learsoft.smartpromotion.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientRestController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/{id}")
	public Client readOne(@PathVariable Integer id) {
		Client client = clientRepository.findById(id).get();
		return client;
	}

	@PatchMapping("/")
	public Client update(@RequestBody Client clientUpdate) {
		Client client = clientRepository.findById(clientUpdate.getId()).get();
		client.setName(clientUpdate.getName());
		client.setLastname(clientUpdate.getLastname());
		return clientRepository.save(client);
	}
	
	@PostMapping("/")
	public Client create(@RequestBody Client client) {
		return clientRepository.save(client);
	}

	@GetMapping("/")
	public List<Client> readAll() {
		List<Client> clients = clientRepository.findAll();
		return clients;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		clientRepository.deleteById(id);
		return "Client Deleted  " + id;
	}
}
