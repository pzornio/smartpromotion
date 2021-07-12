package ar.com.learsoft.smartpromotion.dto;

import ar.com.learsoft.smartpromotion.model.Invoice;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class DTOInvoice extends DTOGeneric {
	private Invoice invoice;

}
