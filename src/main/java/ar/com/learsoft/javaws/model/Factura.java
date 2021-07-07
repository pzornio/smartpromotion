package ar.com.learsoft.javaws.model;

import java.util.Date;
import java.util.List;

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
@Table(name = "factura")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Transient
	private Cliente cliente;
	private Date fecha;
	@Transient
	private List<Producto> productos;
	private Double monto;
	//private String descuento;
	@Transient
	private List<Promocion> promociones;
	//private Integer cantidad;
	private String pago;
	private String canal;

}
