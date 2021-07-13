package ar.com.learsoft.smartpromotion.dto;

import ar.com.learsoft.smartpromotion.model.Promotion;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DTOPromotion extends DTOGeneric{
	
	private Integer id;
	private Integer productId;
	private String code;
	private Integer discount;
	
	public void setPromotion(Promotion promotion) {
		this.id = promotion.getId();
		this.productId = promotion.getProduct().getId();
		this.code = promotion.getCode();
		this.discount = promotion.getDiscount();
	}

}
