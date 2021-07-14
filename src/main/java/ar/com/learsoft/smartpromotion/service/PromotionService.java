package ar.com.learsoft.smartpromotion.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.learsoft.smartpromotion.dto.DTOPromotion;
import ar.com.learsoft.smartpromotion.model.Invoice;
import ar.com.learsoft.smartpromotion.model.Promotion;
import ar.com.learsoft.smartpromotion.repository.PromotionRepository;

@Component("promotionService")
public class PromotionService {
	
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private InvoiceService invoiceService;
	
	public Promotion updatePromotion(DTOPromotion dtoPromotion) {
		Promotion currentPromotion = this.findPromotion(dtoPromotion.getId());
		currentPromotion.setProduct(this.productService.findProduct(dtoPromotion.getProductId()));
		currentPromotion.setCode(dtoPromotion.getCode());
		currentPromotion.setDiscount(dtoPromotion.getDiscount());
		return promotionRepository.save(currentPromotion);
	}
	
	public Promotion findPromotion(Integer idPromotion) {
		return promotionRepository.findById(idPromotion).get();
	}

	public Promotion createPromotion(DTOPromotion dtoPromotion) {
		Promotion promotion = dtoPromotion.buildPromotion();
		promotion.setProduct(this.productService.findProduct(dtoPromotion.getProductId()));
		return promotionRepository.save(promotion);
	}

	public List<Promotion> findAllPromotions() {
		return promotionRepository.findAll();
	}

	public String deletePromotion(Integer id) {
		promotionRepository.deleteById(id);
		return "Promotion Deleted  " + id;
	}

	public List<Promotion> findPromotionsByClient(Integer clientId) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		List<Invoice> invoiceList = this.invoiceService.findInvoiceNewerThan(clientId,calendar.getTimeInMillis());
		
		return null;
	}


	
}
