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
		Client cliente = clientRepository.findById(id).get();
		return cliente;
	}

	@PatchMapping("/")
	public Client update(@RequestBody Client clienteUpdate) {
		Client cliente = clientRepository.findById(clienteUpdate.getId()).get();
		cliente.setName(clienteUpdate.getName());
		cliente.setLastname(clienteUpdate.getLastname());
		return clientRepository.save(cliente);
	}
	
	@PostMapping("/")
	public Client create(@RequestBody Client cliente) {
		return clientRepository.save(cliente);
	}

	@GetMapping("/")
	public List<Client> readAll() {
		List<Client> clientes = clientRepository.findAll();
		return clientes;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		clientRepository.deleteById(id);
		return "Client Deleted  " + id;
	}
}
