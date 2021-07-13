package ar.com.learsoft.smartpromotion.dto;

import ar.com.learsoft.smartpromotion.model.Invoice;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString 
public class DTOInvoice extends DTOGeneric {
	private Invoice invoice;

}
