package ar.com.learsoft.javaws;

import org.springframework.beans.factory.annotation.Autowired;
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
	//comentario

}
