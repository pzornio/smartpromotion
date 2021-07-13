package ar.com.learsoft.smartpromotion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.learsoft.smartpromotion.model.Invoice;
import ar.com.learsoft.smartpromotion.model.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Integer>{
	
}
