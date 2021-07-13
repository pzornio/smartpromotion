package ar.com.learsoft.smartpromotion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.learsoft.smartpromotion.model.Promotion;
import ar.com.learsoft.smartpromotion.repository.PromotionRepository;

@Component("promotionService")
public class PromotionService {
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	public Promotion updatePromotion(Promotion promotion) {
		Promotion currentPromotion = this.findPromotion(promotion.getId());
		currentPromotion.setProduct(promotion.getProduct());
		currentPromotion.setCode(promotion.getCode());
		currentPromotion.setDiscount(promotion.getDiscount());
		return promotionRepository.save(currentPromotion);
	}
	
	public Promotion findPromotion(Integer idPromotion) {
		return promotionRepository.findById(idPromotion).get();
	}

	public Promotion createPromotion(Promotion promotion) {
		return promotionRepository.save(promotion);
	}

	public List<Promotion> findAllPromotions() {
		return promotionRepository.findAll();
	}

	public String deletePromotion(Integer id) {
		promotionRepository.deleteById(id);
		return "Promotion Deleted  " + id;
	}

}
