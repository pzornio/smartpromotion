package ar.com.learsoft.smartpromotion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.learsoft.smartpromotion.model.Client;
import ar.com.learsoft.smartpromotion.model.Invoice;
import ar.com.learsoft.smartpromotion.repository.ClientRepository;
import ar.com.learsoft.smartpromotion.repository.InvoiceRepository;

@Component("invoiceService")
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private ClientRepository clientRepository;

	public Invoice updateInvoice(Invoice invoice) {
		Invoice currentInvoice = this.findInvoice(invoice.getId());
		currentInvoice.setClient(invoice.getClient());
		currentInvoice.setProducts(invoice.getProducts());
		currentInvoice.setDate(invoice.getDate());
		currentInvoice.setPromotions(invoice.getPromotions());
		currentInvoice.setAmount(invoice.getAmount());
		currentInvoice.setChannel(invoice.getChannel());
		currentInvoice.setPaymentMethod(invoice.getPaymentMethod());
		return invoiceRepository.save(currentInvoice);
	}

	public Invoice findInvoice(Integer idInvoice) {
		return invoiceRepository.findById(idInvoice).get();
	}

	public Invoice createInvoice(Invoice invoice) {
		Client client = this.clientRepository.findById(invoice.getClient().getId()).get();
		invoice.setClient(client);
		return invoiceRepository.save(invoice);
	}

	public List<Invoice> findAllInvoices() {
		return invoiceRepository.findAll();
	}

	public String deleteInvoice(Integer id) {
		invoiceRepository.deleteById(id);
		return "Invoice Deleted  " + id;
	}

}
