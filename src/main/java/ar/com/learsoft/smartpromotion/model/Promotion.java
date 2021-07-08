package ar.com.learsoft.smartpromotion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	//	private Producto producto; // decia productos pero no se si es una lista
	private String code;
	private Integer amount;
	private Integer discount;
}
