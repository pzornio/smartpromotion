package ar.com.learsoft.smartpromotion.controller;

import java.util.ArrayList;
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
		DTOInvoice dtoInvoice = new DTOInvoice();
		try {
			Invoice invoice = this.invoiceService.findInvoice(id);
			dtoInvoice.setInvoice(invoice);
			dtoInvoice.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dtoInvoice);
		} catch (NoSuchElementException e) {
			dtoInvoice.setMessage(new SmartMessage("INVOICE ID NOT FOUND"));
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dtoInvoice);
		} catch (Exception e) {
			dtoInvoice.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dtoInvoice);
		}
	}

	@PatchMapping("invoice/")
	public ResponseEntity<DTOInvoice> update(@RequestBody DTOInvoice dtoInvoice) {
		try {
			Invoice invoice = this.invoiceService.updateInvoice(dtoInvoice);
			dtoInvoice.setInvoice(invoice);
			dtoInvoice.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dtoInvoice);
		} catch (NoSuchElementException e) {
			dtoInvoice.setMessage(new SmartMessage("INVOICE ID NOT FOUND"));
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dtoInvoice);
		} catch (Exception e) {
			dtoInvoice.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dtoInvoice);
		}
	}

	@PostMapping("invoice/")
	public ResponseEntity<DTOInvoice> create(@RequestBody DTOInvoice dtoInvoice) {
		try {
			Invoice invoice = this.invoiceService.createInvoice(dtoInvoice);
			dtoInvoice.setInvoice(invoice);
			dtoInvoice.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dtoInvoice);
		} catch (Exception e) {
			e.printStackTrace();
			dtoInvoice.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dtoInvoice);
		}
	}

	@GetMapping("invoice/")
	public ResponseEntity<List<DTOInvoice>> readAll() {
		ArrayList<DTOInvoice> dtoInvoices = new ArrayList<>();
		List<Invoice> invoices = this.invoiceService.findAllInvoices();
		for (Invoice invoice : invoices) {
			DTOInvoice dtoInvoice = new DTOInvoice();
			dtoInvoice.setInvoice(invoice);
			dtoInvoice.setMessage(new SmartMessage("OK"));
			dtoInvoices.add(dtoInvoice);
		}
		return ResponseEntity.ok().body(dtoInvoices);
	}

	@DeleteMapping("invoice/{id}")
	public String delete(@PathVariable Integer id) {
		return this.invoiceService.deleteInvoice(id);
	}
}
