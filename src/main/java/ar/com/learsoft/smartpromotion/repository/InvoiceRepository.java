package ar.com.learsoft.smartpromotion.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.learsoft.smartpromotion.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
	@Query(value = "SELECT i.ID,i.AMOUNT,i.CHANNEL,i.PURCHASE_DATE"
			+ ""
			+ ",i.PAYMENT_METHOD,i.CLIENT_ID,i.DISCOUNT,i.ITEM_COUNT "
			+ "FROM INVOICE i JOIN INVOICE_PRODUCTS ip " + "WHERE i.ID = ip.INVOICE_ID "
			+ "AND i.CLIENT_ID = :clientId " + "AND ip.PRODUCTS_ID = :productId", nativeQuery = true)
	public List<Invoice> findClientProductInvoices(Integer clientId, Integer productId);

	@Query(value = "SELECT * FROM INVOICE WHERE CLIENT_ID= :clientId  and purchase_date > :timestamp", nativeQuery = true)
	public List<Invoice> findInvoiceNewerThan(Integer clientId, Timestamp timestamp);
	
	

}
