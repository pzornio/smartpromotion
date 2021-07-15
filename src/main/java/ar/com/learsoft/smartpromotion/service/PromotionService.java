package ar.com.learsoft.smartpromotion.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.learsoft.smartpromotion.dto.DTOPromotion;
import ar.com.learsoft.smartpromotion.model.Invoice;
import ar.com.learsoft.smartpromotion.model.Product;
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
		List<Promotion> promotionList = new ArrayList<>();
		promotionList.addAll(this.findPromotion1(clientId));
		promotionList.addAll(this.findPromotion2(clientId));
		promotionList.addAll(this.findPromotion3(clientId));
		return promotionList;
	}
	
	public Integer higherValuePromotion(Integer clientId) {
		List<Promotion> list = findPromotionsByClient(clientId); 
		List<Integer> discount= new ArrayList<Integer>();
		for (Promotion promotion : list) {
			discount.add(promotion.getDiscount());
		}
//		Collections.sort(discount);
		return Collections.max(discount);
		
	}
	
	
	private List<Promotion> findPromotion3(Integer clientId){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		List<Product> products = this.productService.findClientProductCount(calendar,clientId,10);
		List<Promotion> promotion3 = new ArrayList<>();
		for (Product product : products) {
			Promotion promotion = new Promotion();
			promotion.setCode("3");
			promotion.setDiscount(25);
			promotion.setProduct(product);
			promotion3.add(promotion);
		}
		return promotion3;
	}
	
	
	private List<Promotion> findPromotion2(Integer clientId){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		List<Product> products = this.productService.findClientProductCount(calendar,clientId,5);
		List<Promotion> promotion2 = new ArrayList<>();
		for (Product product : products) {
			Promotion promotion = new Promotion();
			promotion.setCode("2");
			promotion.setDiscount(20);
			promotion.setProduct(product);
			promotion2.add(promotion);
		}
		return promotion2;
	}
	
	
	private List<Promotion> findPromotion1(Integer clientId){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		List<Product> products = this.productService.findClientProductCount(calendar,clientId,2);
		List<Promotion> promotion1 = new ArrayList<>();
		for (Product product : products) {
			Promotion promotion = new Promotion();
			promotion.setCode("1");
			promotion.setDiscount(15);
			promotion.setProduct(product);
			promotion1.add(promotion);
		}
		return promotion1;
	}

	
}
