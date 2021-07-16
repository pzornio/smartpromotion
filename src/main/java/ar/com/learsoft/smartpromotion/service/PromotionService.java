package ar.com.learsoft.smartpromotion.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.learsoft.smartpromotion.dto.DTOPromotion;
import ar.com.learsoft.smartpromotion.model.Product;
import ar.com.learsoft.smartpromotion.model.Promotion;
import ar.com.learsoft.smartpromotion.repository.PromotionRepository;

@Component("promotionService")
public class PromotionService {

	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private ProductService productService;

	public Promotion updatePromotion(DTOPromotion dtoPromotion) {
		Promotion currentPromotion = this.findPromotion(dtoPromotion.getId());
		currentPromotion.setProductId(dtoPromotion.getProductId());
		currentPromotion.setCode(dtoPromotion.getCode());
		currentPromotion.setDiscount(dtoPromotion.getDiscount());
		return promotionRepository.save(currentPromotion);
	}

	public Promotion findPromotion(Integer idPromotion) {
		return promotionRepository.findById(idPromotion).get();
	}

	public Promotion createPromotion(DTOPromotion dtoPromotion) {
		Promotion promotion = dtoPromotion.buildPromotion();
		promotion.setProductId(dtoPromotion.getProductId());
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
		promotionList.addAll(this.findPromotion4(clientId));
		promotionList.addAll(this.findPromotion5(clientId));
		promotionList.addAll(this.findPromotion6(clientId));
		promotionList.addAll(this.findPromotion7(clientId));
		return promotionList;
	}

	private List<Promotion> findPromotion1(Integer clientId) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		List<Product> products = this.productService.findClientProductCount(calendar, clientId, 2);
		List<Promotion> promotion1 = new ArrayList<>();
		for (Product product : products) {
			Promotion promotion = new Promotion();
			promotion.setCode("1");
			promotion.setDiscount(15);
			promotion.setProductId(product.getId());
			promotion1.add(promotion);
		}
		return promotion1;
	}

	private List<Promotion> findPromotion2(Integer clientId) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		List<Product> products = this.productService.findClientProductCount(calendar, clientId, 5);
		List<Promotion> promotion2 = new ArrayList<>();
		for (Product product : products) {
			Promotion promotion = new Promotion();
			promotion.setCode("2");
			promotion.setDiscount(20);
			promotion.setProductId(product.getId());
			promotion2.add(promotion);
		}
		return promotion2;
	}

	private List<Promotion> findPromotion3(Integer clientId) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		List<Product> products = this.productService.findClientProductCount(calendar, clientId, 10);
		List<Promotion> promotion3 = new ArrayList<>();
		for (Product product : products) {
			Promotion promotion = new Promotion();
			promotion.setCode("3");
			promotion.setDiscount(25);
			promotion.setProductId(product.getId());
			promotion3.add(promotion);
		}
		return promotion3;
	}

	private List<Promotion> findPromotion4(Integer clientId) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		List<Product> products = this.productService.findClientProductAMountTotal(calendar, clientId, 10000);
		List<Promotion> promotion4 = new ArrayList<>();
		for (Product product : products) {
			Promotion promotion = new Promotion();
			promotion.setCode("4");
			promotion.setDiscount(10);
			promotion.setProductId(product.getId());
			promotion4.add(promotion);
		}
		return promotion4;
	}

	private List<Promotion> findPromotion5(Integer clientId) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		List<Product> products = this.productService.findClientProductAMountTotal(calendar, clientId, 20000);
		List<Promotion> promotion5 = new ArrayList<>();
		for (Product product : products) {
			Promotion promotion = new Promotion();
			promotion.setCode("5");
			promotion.setDiscount(15);
			promotion.setProductId(product.getId());
			promotion5.add(promotion);
		}
		return promotion5;
	}

	private List<Promotion> findPromotion6(Integer clientId) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		List<Product> products = this.productService.findClientProductAMountTotal(calendar, clientId, 50000);
		List<Promotion> promotion6 = new ArrayList<>();
		for (Product product : products) {
			Promotion promotion = new Promotion();
			promotion.setCode("6");
			promotion.setDiscount(10);
			promotion.setProductId(product.getId());
			promotion6.add(promotion);
		}
		return promotion6;
	}

	private List<Promotion> findPromotion7(Integer clientId) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		List<Product> products = this.productService.findClientProductAMountTotal(calendar, clientId, 100000);
		List<Promotion> promotion7 = new ArrayList<>();
		for (Product product : products) {
			Promotion promotion = new Promotion();
			promotion.setCode("7");
			promotion.setDiscount(15);
			promotion.setProductId(product.getId());
			promotion7.add(promotion);
		}
		return promotion7;
	}

}
