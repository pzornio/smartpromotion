package ar.com.learsoft.javaws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.learsoft.javaws.model.Factura;
import ar.com.learsoft.javaws.repository.FacturaRepository;

@RestController
public class MyController {

	@Autowired
	private FacturaRepository facturaRepository;

	private Factura saveFactura(Factura factura) {
		return facturaRepository.save(factura);
	}

	@GetMapping("factura/{id}")
	public Factura readInvoice(@PathVariable Integer id) {
		Factura invoice = facturaRepository.getOne(id);
		return invoice;
	}

	@PostMapping("/factura")
	public Factura crearFactura(@RequestBody Factura factura) {
		return factura;
	}

	
	@DeleteMapping("/factura/{id}")
		public String deleteFactura(@PathVariable Integer id) {
			facturaRepository.deleteById(id);
			return "La factura numero  "+id+" fue borrado";
    }

}
