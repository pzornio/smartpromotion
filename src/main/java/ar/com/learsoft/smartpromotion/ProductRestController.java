package ar.com.learsoft.smartpromotion;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.learsoft.smartpromotion.model.Product;
import ar.com.learsoft.smartpromotion.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/{id}")
	public Product readOneProduct(@PathVariable Integer id) {
		Product product = productRepository.findById(id).get();
		return product;
	}

	@PatchMapping("")
	public Product updateProduct(@RequestBody Product productUpdate) {
		Product product = productRepository.findById(productUpdate.getId()).get();
		product.setName(productUpdate.getName());
		product.setType(productUpdate.getType());
		product.setPrice(productUpdate.getPrice());
		product.setDetails(productUpdate.getDetails());
		return productRepository.save(product);
	}
	
	@PostMapping("")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@GetMapping("")
	public List<Product> readAllProduct() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		productRepository.deleteById(id);
		return "Product Deleted  " + id;
	}
}

