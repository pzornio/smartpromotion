package ar.com.learsoft.smartpromotion.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.learsoft.smartpromotion.model.Invoice;
import ar.com.learsoft.smartpromotion.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString 
public class DTOInvoice extends DTOGeneric {
	private Integer invoiceId;
	private Integer clientId;
	private List<Integer> productIds;
	private Date date;
	private Double amount;
	private String descuento;
	private Integer cantidad;
	private String paymentMethod;
	private String channel;
	
	
	public void setInvoice(Invoice invoice) {
		this.invoiceId = invoice.getId();
		this.clientId = invoice.getClient().getId();
		this.productIds = new ArrayList<>();
		for (Product product : invoice.getProducts()) {
			productIds.add(product.getId());
		}
		this.date = invoice.getDate();
		this.amount = invoice.getAmount();
		this.descuento = invoice.getDescuento();
		this.cantidad = invoice.getCantidad();
		this.paymentMethod = invoice.getPaymentMethod();
		this.channel = invoice.getChannel();
	}
}