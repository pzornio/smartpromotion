package ar.com.learsoft.smartpromotion.controller;


import java.util.ArrayList;
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
		DTOProduct dtoProduct = new DTOProduct();
		try {
			Product product= this.productService.findProduct(id);	
			dtoProduct.setProduct(product);
			dtoProduct.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dtoProduct);
		} catch (NoSuchElementException e) {
			dtoProduct.setMessage(new SmartMessage("PRODUCT ID NOT FOUND"));
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dtoProduct);
		} catch (Exception e) {
			dtoProduct.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dtoProduct);
		}
	}
	

	@PatchMapping("product/")
	public ResponseEntity<DTOProduct> update(@RequestBody DTOProduct dtoProduct) {
		try {
			Product updatedProduct = this.productService.updateProduct(dtoProduct);
			dtoProduct.setProduct(updatedProduct);
			dtoProduct.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dtoProduct);
		} catch (NoSuchElementException e) {
			dtoProduct.setMessage(new SmartMessage("PRODUCT ID NOT FOUND"));
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dtoProduct);
		} catch (Exception e) {
			dtoProduct.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dtoProduct);
		}
	}

	@PostMapping("product/")
	public ResponseEntity<DTOProduct> create(@RequestBody DTOProduct dtoProduct) {
		try {
			Product newProduct = this.productService.createProduct(dtoProduct);
			dtoProduct.setProduct(newProduct);
			dtoProduct.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dtoProduct);
		} catch (Exception e) {
			dtoProduct.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dtoProduct);
		}
	}
	
	@GetMapping("product/")
	public ResponseEntity<List<DTOProduct>> readAll() {
		ArrayList<DTOProduct> dtoProducts = new ArrayList<>();
		List<Product> products = this.productService.findAllProducts();
		for (Product product : products) {
			DTOProduct dtoProduct = new DTOProduct();
			dtoProduct.setProduct(product);
			dtoProduct.setMessage(new SmartMessage("OK"));
		}
		return ResponseEntity.ok().body(dtoProducts);
	}

	@DeleteMapping("product/{id}")
	public String delete(@PathVariable Integer id) {
		return this.productService.deleteProduct(id);
	}
}

