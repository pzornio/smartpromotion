package ar.com.learsoft.smartpromotion.dto;

import ar.com.learsoft.smartpromotion.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DTOProduct extends DTOGeneric {
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

	public Product getProduct() {
		Product product = new Product();
		product.setId(this.id);
		product.setName(this.name);
		product.setType(this.type);
		product.setPrice(this.price);
		product.setDetails(this.details);
		return product;
	}

}
