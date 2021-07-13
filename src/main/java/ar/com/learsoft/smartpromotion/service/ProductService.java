package ar.com.learsoft.smartpromotion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.learsoft.smartpromotion.dto.DTOProduct;
import ar.com.learsoft.smartpromotion.model.Product;
import ar.com.learsoft.smartpromotion.repository.ProductRepository;

@Component("productService")
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product updateProduct(DTOProduct dtoproduct) {
		Product currentProduct = this.findProduct(dtoproduct.getId());
		currentProduct.setName(dtoproduct.getName());
		currentProduct.setType(dtoproduct.getType());
		currentProduct.setDetails(dtoproduct.getDetails());
		currentProduct.setPrice(dtoproduct.getPrice());
		return productRepository.save(currentProduct);
	}

	public Product findProduct(Integer idProduct) {
		return productRepository.findById(idProduct).get();
	}

	public Product createProduct(DTOProduct dtoProduct) {
		Product product = dtoProduct.buildProduct();
		return productRepository.save(product);
	}

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public String deleteProduct(Integer id) {
		productRepository.deleteById(id);
		return "Product Deleted  " + id;
	}
}
