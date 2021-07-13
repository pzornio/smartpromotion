package ar.com.learsoft.smartpromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.learsoft.smartpromotion.dto.DTOPromotion;
import ar.com.learsoft.smartpromotion.model.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Integer>{

	Promotion save(DTOPromotion dtoPromotion);
	
}
