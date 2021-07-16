package ar.com.learsoft.smartpromotion.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Promotion")
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	private Integer productId;
	private String code;
	private Integer discount;
	@ManyToMany
	private List<Invoice> invoices;
	
}
