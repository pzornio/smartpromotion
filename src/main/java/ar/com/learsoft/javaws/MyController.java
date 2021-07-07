package ar.com.learsoft.javaws;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.learsoft.javaws.model.Client;
import ar.com.learsoft.javaws.repository.ClientRepository;

@RestController
public class MyController {
    
	@Autowired 
	private ClientRepository clientRepository;
	
	
	//CRUD CLIENT
	
	//CREATE
	@PostMapping("/client")
	public Client createClient(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	
	//READ
	@GetMapping("/client/{id}")
	public Client readClient(@PathVariable Integer id) {
		Client client = clientRepository.getOne(id);
		return client;
	}
	
	//UPDATE
	@PatchMapping("/client")
	public Client updateClient(@RequestBody Client clientUpdate) {
		Client client = clientRepository.getOne(clientUpdate.getId());
		client.setApellido(clientUpdate.getApellido());
		client.setNombre(clientUpdate.getNombre());
		return clientRepository.save(client);
	}
	
	//DELETE	
	@DeleteMapping("/client/{id}")
	public String deleteClient(@PathVariable Integer id) {
		clientRepository.deleteById(id);
		return "El cliente " + id + " fue borrado";
	}
	

  
}
