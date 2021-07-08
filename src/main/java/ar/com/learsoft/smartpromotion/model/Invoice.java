package ar.com.learsoft.smartpromotion.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Invoice")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	@JsonIgnore
	private Integer clientId;
	@Transient	
	private Client client;
	private Date date;
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Product> products;
	private Double amount;
	//private String descuento;
	@Transient
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	private List<Promotion> promotions;
	//private Integer cantidad;
	private String paymentMethod;
	private String channel;

}
