package ar.com.learsoft.javaws.model;

import java.util.List;

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
@Table(name= "Promocion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Promocion {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Producto producto; // decia productos pero no se si es una lista
	private String codigo;
	private Integer cantidades;
	private Integer descuento;
}
