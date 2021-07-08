package ar.com.learsoft.smartpromotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.learsoft.smartpromotion.model.Invoice;
import ar.com.learsoft.smartpromotion.repository.InvoiceRepository;

@RestController
@RequestMapping("/invoice")
public class InvoiceRestController {

	@Autowired
	private InvoiceRepository invoiceRepository;

	private Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	@GetMapping("/{id}")
	public Invoice readInvoice(@PathVariable Integer id) {
		Invoice invoice = invoiceRepository.getOne(id);
		return invoice;
	}

	@PostMapping("/")
	public Invoice createInvoice(@RequestBody Invoice invoice) {
		return saveInvoice(invoice);
	}

	
	@DeleteMapping("/{id}")
		public String deleteInvoice(@PathVariable Integer id) {
			invoiceRepository.deleteById(id);
			return "Invoice N "+id+" was deleted.";
    }

}