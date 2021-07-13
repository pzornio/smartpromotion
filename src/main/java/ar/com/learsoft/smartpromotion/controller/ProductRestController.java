package ar.com.learsoft.smartpromotion.controller;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.learsoft.smartpromotion.dto.DTOProduct;
import ar.com.learsoft.smartpromotion.dto.SmartMessage;
import ar.com.learsoft.smartpromotion.model.Product;
import ar.com.learsoft.smartpromotion.service.ProductService;

@RestController
@RequestMapping("/API_INVOICE/")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping("product/{id}")
	public ResponseEntity<DTOProduct> readOne(@PathVariable Integer id) {
		DTOProduct dTOProduct = new DTOProduct();
		try {
			Product product= this.productService.findProduct(id);	
			dTOProduct.setProduct(product);
			dTOProduct.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dTOProduct);
		} catch (NoSuchElementException e) {
			dTOProduct.setMessage(new SmartMessage("INVOICE ID NOT FOUND"));
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dTOProduct);
		} catch (Exception e) {
			dTOProduct.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dTOProduct);
		}
	}
	

	@PatchMapping("product/")
	public Product update(@RequestBody Product product) {
		return this.productService.updateProduct(product);
	}

	@PostMapping("product/")
	public Product create(@RequestBody Product product) {
		return this.productService.createProduct(product);
	}

	@GetMapping("product/")
	public List<Product> readAll() {
		return this.productService.findAllProducts();
	}

	@DeleteMapping("product/{id}")
	public String delete(@PathVariable Integer id) {
		return this.productService.deleteProduct(id);
	}
}

