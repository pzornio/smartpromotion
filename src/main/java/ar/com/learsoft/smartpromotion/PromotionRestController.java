package ar.com.learsoft.smartpromotion;

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

<<<<<<< HEAD
import ar.com.learsoft.smartpromotion.model.Client;
import ar.com.learsoft.smartpromotion.model.Product;
import ar.com.learsoft.smartpromotion.model.Promotion;
import ar.com.learsoft.smartpromotion.repository.ProductRepository;
import ar.com.learsoft.smartpromotion.repository.PromotionRepository;
=======
import ar.com.learsoft.smartpromotion.dto.DTOPromotion;
import ar.com.learsoft.smartpromotion.dto.SmartMessage;
import ar.com.learsoft.smartpromotion.model.Promotion;
import ar.com.learsoft.smartpromotion.service.PromotionService;
>>>>>>> a0efd929294a1fa018c0a2ac0dd6b445fbb0781e

@RestController
@RequestMapping("/promotionAPI")
public class PromotionRestController{

	@Autowired
<<<<<<< HEAD
	private PromotionRepository promotionRepository;
	
=======
	private PromotionService promotionService;
>>>>>>> a0efd929294a1fa018c0a2ac0dd6b445fbb0781e

	@GetMapping("/{id}")
	public ResponseEntity<DTOPromotion> readOne(@PathVariable Integer id) {
		DTOPromotion dTOPromotion = new DTOPromotion();
		try {
			Promotion promotion= this.promotionService.findPromotion(id);	
			dTOPromotion.setPromotion(promotion);
			dTOPromotion.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dTOPromotion);
		} catch (NoSuchElementException e) {
			dTOPromotion.setMessage(new SmartMessage("INVOICE ID NOT FOUND"));
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dTOPromotion);
		} catch (Exception e) {
			dTOPromotion.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dTOPromotion);
		}
	}
	

<<<<<<< HEAD
	@GetMapping("/{id}")
	public Promotion readPromotion(@PathVariable Integer id) {
		Promotion promotion = promotionRepository.getOne(id);
		
		
		return promotion;
	}

	@PostMapping("")
	public Promotion createPromotion(@RequestBody Promotion promotion) {
		Product product = promotion.getProduct();
		promotion.setProductId(product.getId());
		return savePromotion(promotion);
=======
	@PatchMapping("/")
	public Promotion update(@RequestBody Promotion promotion) {
		return this.promotionService.updatePromotion(promotion);
	}

	@PostMapping("/")
	public Promotion create(@RequestBody Promotion promotion) {
		return this.promotionService.createPromotion(promotion);
	}

	@GetMapping("/")
	public List<Promotion> readAll() {
		return this.promotionService.findAllPromotions();
>>>>>>> a0efd929294a1fa018c0a2ac0dd6b445fbb0781e
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		return this.promotionService.deletePromotion(id);
	}

}