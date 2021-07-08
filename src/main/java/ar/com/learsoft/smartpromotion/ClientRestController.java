package ar.com.learsoft.smartpromotion;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.learsoft.smartpromotion.dto.DTOClient;
import ar.com.learsoft.smartpromotion.dto.SmartMessage;
import ar.com.learsoft.smartpromotion.model.Client;
import ar.com.learsoft.smartpromotion.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientRestController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/{id}")
	public ResponseEntity<DTOClient> readOne(@PathVariable Integer id) {
		DTOClient dtoClient = new DTOClient();
		try {
			Client client= this.clientService.findClient(id);	
			dtoClient.setClient(client);
			dtoClient.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dtoClient);
		} catch (NoSuchElementException e) {
			dtoClient.setMessage(new SmartMessage("CLIENT ID NOT FOUND"));
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dtoClient);
		} catch (Exception e) {
			dtoClient.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dtoClient);
		}
	}

	@PatchMapping("/")
	public Client update(@RequestBody Client client) {
		return this.clientService.updateClient(client);
	}

	@PostMapping("/")
	public Client create(@RequestBody Client client) {
		return this.clientService.createClient(client);
	}

	@GetMapping("/")
	public List<Client> readAll() {
		return this.clientService.findAllClients();
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		return this.clientService.deleteClient(id);
	}
}
