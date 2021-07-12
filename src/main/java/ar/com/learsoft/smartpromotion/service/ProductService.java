package ar.com.learsoft.smartpromotion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.learsoft.smartpromotion.model.Product;
import ar.com.learsoft.smartpromotion.repository.ProductRepository;

@Component("productService")
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product updateProduct(Product product) {
		Product currentProduct = this.findProduct(product.getId());
		currentProduct.setName(product.getName());
		currentProduct.setType(product.getType());
		currentProduct.setDetails(product.getDetails());
		currentProduct.setPrice(product.getPrice());
		return productRepository.save(currentProduct);
	}
	
	public Product findProduct(Integer idProduct) {
		return productRepository.findById(idProduct).get();
	}

	public Product createProduct(Product product) {
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
