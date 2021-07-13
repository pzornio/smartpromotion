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

import ar.com.learsoft.smartpromotion.dto.DTOClient;
import ar.com.learsoft.smartpromotion.dto.DTOPromotion;
import ar.com.learsoft.smartpromotion.dto.SmartMessage;
import ar.com.learsoft.smartpromotion.model.Client;
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
			dTOPromotion.setMessage(new SmartMessage("PROMOTION ID NOT FOUND"));
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dTOPromotion);
		} catch (Exception e) {
			dTOPromotion.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dTOPromotion);
		}
	}
	

	@PatchMapping("promotion/")
	public ResponseEntity<DTOPromotion> update(@PathVariable Promotion promotion) {
		DTOPromotion dTOPromotion = new DTOPromotion();
		try {
			Promotion updatedPromotion= this.promotionService.updatePromotion(promotion);
			dTOPromotion.setPromotion(updatedPromotion);
			dTOPromotion.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dTOPromotion);
		} catch (NoSuchElementException e) {
			dTOPromotion.setMessage(new SmartMessage("PROMOTION ID NOT FOUND"));
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dTOPromotion);
		} catch (Exception e) {
			dTOPromotion.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dTOPromotion);
		}
	}
	
	@PostMapping("promotion/")
	public ResponseEntity<DTOPromotion> create(@RequestBody Promotion promotion) {
		DTOPromotion dTOPromotion = new DTOPromotion();
		try {
			Promotion newPromotion= this.promotionService.createPromotion(promotion);
			dTOPromotion.setPromotion(newPromotion);
			dTOPromotion.setMessage(new SmartMessage("OK"));
			return ResponseEntity.ok().body(dTOPromotion);
		} catch (Exception e) {
			dTOPromotion.setMessage(new SmartMessage("ERROR INESPERADO"));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dTOPromotion);
		}
	}
	
	@GetMapping("promotion/")
	public ResponseEntity<List<DTOPromotion>> readAll() {
		ArrayList<DTOPromotion> dtoPromotions = new ArrayList<>();
		List<Promotion> promotions = this.promotionService.findAllPromotions();
		for (Promotion promotion : promotions) {
			DTOPromotion dtoPromotion = new DTOPromotion();
			dtoPromotion.setPromotion(promotion);
			dtoPromotion.setMessage(new SmartMessage("OK"));
		}
		return ResponseEntity.ok().body(dtoPromotions);
	}

	@DeleteMapping("promotion/{id}")
	public String delete(@PathVariable Integer id) {
		return this.promotionService.deletePromotion(id);
	}

}