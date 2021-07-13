package ar.com.learsoft.smartpromotion.promotion;

import ar.com.learsoft.smartpromotion.model.Invoice;
import ar.com.learsoft.smartpromotion.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Setter
@Getter
public class ListOfProducts {
	
	private List<Invoice> invoices;
	private Invoice invoice;
	
	public List<HashMap<String, Integer>> quantityOfProducts() {

		List<HashMap<String, Integer>> quantityOfInvoice= new ArrayList<HashMap<String,Integer>>();
		
		for (Invoice invoice2 : invoices) {
			this.invoice= invoice2;
			HashMap<String, Integer> quantityOfProducts= new HashMap<String, Integer>();
			List<Product> products= this.invoice.getProducts();
			
			
			for (Product product : products) {
				if(quantityOfProducts.containsKey(product.getName())) {
					quantityOfProducts.put(product.getName(), (quantityOfProducts.get(product.getName())+1));
					
				}else {
					quantityOfProducts.put(product.getName(), 1);
				}
				
			}
			quantityOfInvoice.add(quantityOfProducts);
		}
		System.out.println(quantityOfInvoice.toString());
		return quantityOfInvoice;
	}

}