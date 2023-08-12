package com.mx.proyecto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // ANOTACION PARA INDICARLE QUE ESTA CLASE VA A SER UNA ENTITY
@Table(name = "TIPO_DE_TRABAJADOR", schema = "CAPACITACION1") // Anotacion table donde indicamos el nombre de la tabla y el esquema
public class TipoTrabajadorEntity {
	
	@Id // Es para indicarle que el campo/atributo va ser un id,tambien suele ser la llave primaria
	@Column(name = "ID_TIPO", unique = true, nullable = false, precision = 3) // Es para indicar que es una columna de la tabla y se pueden agregar propiedades
	private Long idTipo;
	
	@Column(name = "TIPO_TRABAJADOR")
	private String tipoTrabajador;

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public String getTipoTrabajador() {
		return tipoTrabajador;
	}

	public void setTipoTrabajador(String tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}
	
	

}
