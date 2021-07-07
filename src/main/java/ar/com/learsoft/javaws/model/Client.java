package ar.com.learsoft.javaws.model;

import java.io.Serializable;

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
@Table(name= "Client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private String apellido;
//	private List<Telefono> telefonos;
//	private List<Direccion> direcciones;
//	private Ocupacion ocupacion;
	
	
}
