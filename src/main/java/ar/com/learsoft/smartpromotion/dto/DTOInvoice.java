package ar.com.learsoft.smartpromotion.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ar.com.learsoft.smartpromotion.model.Invoice;
import ar.com.learsoft.smartpromotion.model.Product;
import ar.com.learsoft.smartpromotion.model.Promotion;
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
	private List<Integer> promotionIds;
	private Timestamp purchaseDate;
	private Double amount;
	private String descuento;
	private Integer itemCount;
	private String paymentMethod;
	private String channel;

	public void setInvoice(Invoice invoice) {
		this.invoiceId = invoice.getId();
		this.clientId = invoice.getClient().getId();
		this.productIds = new ArrayList<>();
		for (Product product : invoice.getProducts()) {
			productIds.add(product.getId());
		}
		this.promotionIds = new ArrayList<>();
		if (invoice.getPromotions() != null) {
			for (Promotion promotion : invoice.getPromotions()) {
				promotionIds.add(promotion.getId());
			}
		}
		this.purchaseDate = invoice.getPurchaseDate();
		this.amount = invoice.getAmount();
		this.descuento = invoice.getDescuento();
		this.itemCount = invoice.getItemCount();
		this.paymentMethod = invoice.getPaymentMethod();
		this.channel = invoice.getChannel();
	}
}
