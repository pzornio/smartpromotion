package ar.com.learsoft.smartpromotion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.learsoft.smartpromotion.dto.DTOPromotion;
import ar.com.learsoft.smartpromotion.model.Promotion;
import ar.com.learsoft.smartpromotion.repository.PromotionRepository;

@Component("promotionService")
public class PromotionService {
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	public Promotion updatePromotion(DTOPromotion dtoPromotion) {
		Promotion currentPromotion = this.findPromotion(dtoPromotion.getId());
		currentPromotion.setProduct(dtoPromotion.getProductId());
		currentPromotion.setCode(dtoPromotion.getCode());
		currentPromotion.setDiscount(dtoPromotion.getDiscount());
		return promotionRepository.save(currentPromotion);
	}
	
	public Promotion findPromotion(Integer idPromotion) {
		return promotionRepository.findById(idPromotion).get();
	}

	public Promotion createPromotion(DTOPromotion dtoPromotion) {
		return promotionRepository.save(dtoPromotion);
	}

	public List<Promotion> findAllPromotions() {
		return promotionRepository.findAll();
	}

	public String deletePromotion(Integer id) {
		promotionRepository.deleteById(id);
		return "Promotion Deleted  " + id;
	}
	
}
