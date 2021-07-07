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

import ar.com.learsoft.javaws.repository.FacturaRepository;


@RestController
public class MyController {
    
	@Autowired 
	private FacturaRepository facturaRepository;
	
	//DELETE	
		@DeleteMapping("/factura/{id}")
		public String deleteClient(@PathVariable Integer id) {
			facturaRepository.deleteById(id);
			return "Dejo algo escrito para dar a enterde que el "+id+" fue borrado";
		}
		

}
