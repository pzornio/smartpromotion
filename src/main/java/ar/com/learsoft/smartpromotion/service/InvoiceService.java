package ar.com.learsoft.smartpromotion.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.learsoft.smartpromotion.dto.DTOInvoice;
import ar.com.learsoft.smartpromotion.model.Client;
import ar.com.learsoft.smartpromotion.model.Invoice;
import ar.com.learsoft.smartpromotion.model.Product;
import ar.com.learsoft.smartpromotion.model.Promotion;
import ar.com.learsoft.smartpromotion.repository.InvoiceRepository;

@Component("invoiceService")
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private ClientService clientService;
	@Autowired
	private PromotionService promotionService;
	@Autowired
	private ProductService productService;

	public Invoice updateInvoice(DTOInvoice dtoInvoice) {
		Invoice currentInvoice = this.findInvoice(dtoInvoice.getInvoiceId());
		this.buildInvoice(currentInvoice, dtoInvoice);
		return invoiceRepository.save(currentInvoice);
	}

	public Invoice findInvoice(Integer idInvoice) {
		return invoiceRepository.findById(idInvoice).get();
	}

	public Invoice createInvoice(DTOInvoice dtoInvoice) {
		Invoice invoice = new Invoice();
		Timestamp purchaseDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
		dtoInvoice.setPurchaseDate(purchaseDate);
		this.buildInvoice(invoice, dtoInvoice);
		return invoiceRepository.save(invoice);
	}

	public List<Invoice> findAllInvoices() {
		return invoiceRepository.findAll();
	}
	
	public List<Invoice> findClientProductInvoices(Integer clientId, Integer productId) {
		return invoiceRepository.findClientProductInvoices(clientId, productId);
	}

	public String deleteInvoice(Integer id) {
		invoiceRepository.deleteById(id);
		return "Invoice Deleted  " + id;
	}
	
	private Invoice buildInvoice(Invoice invoice, DTOInvoice dtoInvoice) {
		Client client = clientService.findClient(dtoInvoice.getClientId());
		invoice.setClient(client);
		
		
//		List<Integer> promotionIds = dtoInvoice.getPromotionIds();
//		if(promotionIds != null) {
//			ArrayList<Promotion> promotions = new ArrayList<>();
//			for (Integer promotionId : promotionIds) {
//				Promotion promotion = promotionService.findPromotion(promotionId);
//				promotions.add(promotion);
//			}
//			invoice.setPromotions(promotions);	
//		}		
		
		
		
		List<Integer> productIds = dtoInvoice.getProductIds();
		List<Promotion> promotions = new ArrayList<>();
		
		ArrayList<Product> products = new ArrayList<>();
		for (Integer productId : productIds) {
			Product product = productService.findProduct(productId);
			products.add(product);
			promotions.addAll(promotionService.findPromotionsByClient(dtoInvoice.getClientId()));
		}
		
		
		invoice.setPromotions(promotions);		
		invoice.setProducts(products);	
		invoice.setPurchaseDate(dtoInvoice.getPurchaseDate());	
		invoice.setAmount(dtoInvoice.getAmount());
		invoice.setChannel(dtoInvoice.getChannel());
		invoice.setDiscount(dtoInvoice.getDiscount());
		invoice.setItemCount(dtoInvoice.getItemCount());
		invoice.setPaymentMethod(dtoInvoice.getPaymentMethod());
		return invoice;
	}

	public List<Invoice> findInvoiceNewerThan(Integer clientId, Long timeInMillis) {
		Timestamp timestamp = new Timestamp(timeInMillis);
		List<Invoice> list = this.invoiceRepository.findInvoiceNewerThan(clientId,timestamp);
		return list;
	}

}
