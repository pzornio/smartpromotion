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

import ar.com.learsoft.smartpromotion.dto.DTOPromotion;
import ar.com.learsoft.smartpromotion.dto.SmartMessage;
import ar.com.learsoft.smartpromotion.model.Promotion;
import ar.com.learsoft.smartpromotion.service.PromotionService;

@RestController
@RequestMapping("/API_PROMOTION/")
public class PromotionRestController{

	@Autowired
	private PromotionService promotionService;

	@GetMapping("promotion/{id}")
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
	

	@PatchMapping("promotion/")
	public Promotion update(@RequestBody Promotion promotion) {
		return this.promotionService.updatePromotion(promotion);
	}

	@PostMapping("promotion/")
	public Promotion create(@RequestBody Promotion promotion) {
		return this.promotionService.createPromotion(promotion);
	}

	@GetMapping("promotion/")
	public List<Promotion> readAll() {
		return this.promotionService.findAllPromotions();
	}

	@DeleteMapping("promotion/{id}")
	public String delete(@PathVariable Integer id) {
		return this.promotionService.deletePromotion(id);
	}

}