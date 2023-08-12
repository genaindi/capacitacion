package com.mx.proyecto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // ANOTACION PARA INDICARLE QUE ESTA CLASE VA A SER UNA ENTITY
@Table(name = "MES", schema = "CAPACITACION1") // Anotacion table donde indicamos el nombre de la tabla y el esquema
public class MesEntity {
	
	@Id // Es para indicarle que el campo/atributo va ser un id,tambien suele ser la llave primaria
	@Column(name = "ID_MES", unique = true, nullable = false, precision = 3) // Es para indicar que es una columna de la tabla y se pueden agregar propiedades
	private Long idMes;
	
	@Column(name = "NOMBRE_MES")
	private String nombreMes;

	public Long getIdMes() {
		return idMes;
	}

	public void setIdMes(Long idMes) {
		this.idMes = idMes;
	}

	public String getNombreMes() {
		return nombreMes;
	}

	public void setNombreMes(String nombreMes) {
		this.nombreMes = nombreMes;
	}
	
	

}
