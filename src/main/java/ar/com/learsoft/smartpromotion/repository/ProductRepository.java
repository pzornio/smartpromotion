package ar.com.learsoft.smartpromotion.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.learsoft.smartpromotion.model.Invoice;
import ar.com.learsoft.smartpromotion.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	
	@Query(value = "SELECT p.ID, p.DETAILS, p.NAME, p.PRICE, p.TYPE  FROM PRODUCT p JOIN (SELECT COUNT(*) COUNT_VAL, ip.PRODUCTS_ID FROM INVOICE_PRODUCTS ip JOIN (SELECT ID INVOICE_ID FROM INVOICE WHERE CLIENT_ID= :clientId and purchase_date > :timestamp) i  WHERE i.INVOICE_ID=ip.INVOICE_ID GROUP BY  ip.PRODUCTS_ID ) pc WHERE pc.PRODUCTS_ID  = p.ID AND COUNT_VAL>:itemCount", nativeQuery = true)
	public List<Product> findClientProductCount(Integer clientId, Timestamp timestamp,Integer itemCount);
}
