package ar.com.learsoft.smartpromotion.dto;

import ar.com.learsoft.smartpromotion.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DTOProduct extends DTOGeneric{
	private Integer id;
	private String name;
	private String type;
	private Double price;
	private String details;
	
	public void setProduct(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.type = product.getType();
		this.price = product.getPrice();
		this.details = product.getDetails();
	}
	
}
