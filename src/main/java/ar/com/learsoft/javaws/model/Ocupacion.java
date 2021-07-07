package ar.com.learsoft.javaws.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Ocupacion {
	private String puesto;
	private String empresa;
	private Industria industria;
}
