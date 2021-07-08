package ar.com.learsoft.javaws;

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

import ar.com.learsoft.javaws.model.Cliente;
import ar.com.learsoft.javaws.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientRestController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/{id}")
	public Cliente readOne(@PathVariable Integer id) {
		Cliente cliente = clientRepository.findById(id).get();
		return cliente;
	}

	@PatchMapping("/")
	public Cliente update(@RequestBody Cliente clienteUpdate) {
		Cliente cliente = clientRepository.findById(clienteUpdate.getId()).get();
		cliente.setNombre(clienteUpdate.getNombre());
		cliente.setApellido(clienteUpdate.getApellido());
		return clientRepository.save(cliente);
	}
	
	@PostMapping("/")
	public Cliente create(@RequestBody Cliente cliente) {
		return clientRepository.save(cliente);
	}

	@GetMapping("/")
	public List<Cliente> readAll() {
		List<Cliente> clientes = clientRepository.findAll();
		return clientes;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		clientRepository.deleteById(id);
		return "Client Deleted  " + id;
	}
}
