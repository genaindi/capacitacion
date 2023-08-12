package com.mx.proyecto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // ANOTACION PARA INDICARLE QUE ESTA CLASE VA A SER UNA ENTITY
@Table(name = "REGIMEN_AFILIACION", schema = "CAPACITACION1") // Anotacion table donde indicamos el nombre de la tabla y el esquema

public class RegimenAfilEntity {
	
	@Id // Es para indicarle que el campo/atributo va ser un id,tambien suele ser la llave primaria
	@Column(name = "ID_REGIMEN", unique = true, nullable = false, precision = 3) // Es para indicar que es una columna de la tabla y se pueden agregar propiedades
	private Long idRegimen;
	
	@Column(name = "REGIMEN")
	private String regimen;

	public Long getIdRegimen() {
		return idRegimen;
	}

	public void setIdRegimen(Long idRegimen) {
		this.idRegimen = idRegimen;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}
	
	

}
