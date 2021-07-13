package ar.com.learsoft.smartpromotion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	@Transient
	private Product product;
	private String code;
	private Integer discount;
}
