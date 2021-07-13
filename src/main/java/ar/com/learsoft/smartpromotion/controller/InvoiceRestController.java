package ar.com.learsoft.smartpromotion.controller;

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

import ar.com.learsoft.smartpromotion.dto.DTOInvoice;
import ar.com.learsoft.smartpromotion.dto.SmartMessage;
import ar.com.learsoft.smartpromotion.model.Invoice;
import ar.com.learsoft.smartpromotion.service.InvoiceService;

@RestController
@RequestMapping("/API_INVOICE/")
public class InvoiceRestController {

	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("invoice/{id}")
	public ResponseEntity<DTOInvoice> readOne(@PathVariable Integer id) {
		DTOInvoice dTOInvoice = new DTOInvoice();
		try {
			Invoice invoice = this.invoiceService.findInvoice(id);
			dTOInvoice.setInvoice(invoice);
			dTOInvoice.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dTOInvoice);
		} catch (NoSuchElementException e) {
			dTOInvoice.setMessage(new SmartMessage("INVOICE ID NOT FOUND"));
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dTOInvoice);
		} catch (Exception e) {
			dTOInvoice.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dTOInvoice);
		}
	}

	@PatchMapping("invoice/")
	public Invoice update(@RequestBody Invoice invoice) {
		return this.invoiceService.updateInvoice(invoice);
	}

	@PostMapping("invoice/")
	public Invoice create(@RequestBody Invoice invoice) {
		return this.invoiceService.createInvoice(invoice);
	}

	@GetMapping("invoice/")
	public List<Invoice> readAll() {
		return this.invoiceService.findAllInvoices();
	}

	@DeleteMapping("invoice/{id}")
	public String delete(@PathVariable Integer id) {
		return this.invoiceService.deleteInvoice(id);
	}
}
