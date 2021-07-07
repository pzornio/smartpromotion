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

import ar.com.learsoft.javaws.model.Factura;


@RestController
public class MyController {
    
	@GetMapping("factura/{id}")
	public Factura readInvoice(@PathVariable Integer id) {
		Factura invoice = facturaRepository.getOne(id);
		return invoice;
	}
	
  
}
