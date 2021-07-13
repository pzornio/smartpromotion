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
	
	public List<HashMap<Product, Integer>> quantityOfProducts() {

		List<HashMap<Product, Integer>> quantityOfInvoice= new ArrayList<HashMap<Product,Integer>>();
		
		for (Invoice invoice2 : invoices) {
			this.invoice= invoice2;
			HashMap<Product, Integer> quantityOfProducts= new HashMap<Product, Integer>();
			List<Product> products= this.invoice.getProducts();
			
			
			for (Product product : products) {
				if(quantityOfProducts.containsKey(product)) {
					quantityOfProducts.put(product, (quantityOfProducts.get(product)+1));
					
				}else {
					quantityOfProducts.put(product, 1);
				}
				
			}
			quantityOfInvoice.add(quantityOfProducts);
		}
		System.out.println(quantityOfInvoice.toString());
		return quantityOfInvoice;
	}

}