package ar.com.learsoft.smartpromotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.learsoft.smartpromotion.model.Client;
import ar.com.learsoft.smartpromotion.model.Product;
import ar.com.learsoft.smartpromotion.model.Promotion;
import ar.com.learsoft.smartpromotion.repository.ProductRepository;
import ar.com.learsoft.smartpromotion.repository.PromotionRepository;

@RestController
@RequestMapping("/promotion")
public class PromotionRestController{

	@Autowired
	private PromotionRepository promotionRepository;
	

	private Promotion savePromotion(Promotion promotion) {
		return promotionRepository.save(promotion);
	}

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
	}

	
	@DeleteMapping("/{id}")
		public String deletePromotion(@PathVariable Integer id) {
		promotionRepository.deleteById(id);
			return "Promotion N " + id + " was deleted.";
    }

}