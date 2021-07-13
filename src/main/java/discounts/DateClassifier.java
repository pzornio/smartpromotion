package discounts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.learsoft.smartpromotion.model.Invoice;

public class DateClassifier {

	private List<Invoice> updateInvoice = new ArrayList<Invoice>();

	@SuppressWarnings("deprecation")
	public List<Invoice> sameMonth(List<Invoice> invoice) {
		for (Invoice e : invoice) {
			Date date1 = new Date();
			date1.setDate(LocalDate.now().getDayOfMonth());
			date1.setYear(LocalDate.now().getYear());
			date1.setMonth(LocalDate.now().getMonthValue() - 1);
			if (e.getDate().after(date1) == true) {
				updateInvoice.add(e);

			}
		}
		return updateInvoice;
	}

	@SuppressWarnings("deprecation")
	public List<Invoice> sameYear(List<Invoice> invoice) {
		for (Invoice e : invoice) {
			Date date1 = new Date();
			date1.setDate(LocalDate.now().getDayOfMonth());
			date1.setYear(LocalDate.now().getYear() - 1);
			date1.setMonth(LocalDate.now().getMonthValue());
			if (e.getDate().after(date1) == true) {
				updateInvoice.add(e);

			}
		}
		return updateInvoice;

	}

	public List<Invoice> customTime(List<Invoice> invoice, Date date) {
		for (Invoice e : invoice) {
			if (e.getDate().after(date) == true) {
				updateInvoice.add(e);

			}
		}
		return updateInvoice;

	}

}
