package com.mx.proyecto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // ANOTACION PARA INDICARLE QUE ESTA CLASE VA A SER UNA ENTITY
@Table(name = "CODIGO_DE_ORIGEN", schema = "CAPACITACION1") // Anotacion table donde indicamos el nombre de la tabla y el esquema
public class CodigoOrigenEntity {
	
	@Id // Es para indicarle que el campo/atributo va ser un id,tambien suele ser la llave primaria
	@Column(name = "ID_CODIGO", unique = true, nullable = false, precision = 3) // Es para indicar que es una columna de la tabla y se pueden agregar propiedades
	private Long idCodigo;
	
	@Column(name = "CODIGO_ORIGEN")
	private String codigoOrigen;

	public Long getIdCodigo() {
		return idCodigo;
	}

	public void setIdCodigo(Long idCodigo) {
		this.idCodigo = idCodigo;
	}

	public String getCodigoOrigen() {
		return codigoOrigen;
	}

	public void setCodigoOrigen(String codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}
	
	

}
