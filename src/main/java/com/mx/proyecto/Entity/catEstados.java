package com.mx.proyecto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Anotacion para indicarle que esta clase va a ser una entity/entidad
@Table(name = "CAT_ESTADOS", schema = "CAPACITACION1") // Anotacion table donde indicamos el nombre de la tabla y el esquema
public class catEstados {
	
	@Id // Es para indicarle que el campo/atributo va ser un id,tambien suele ser la llave primaria
	@Column(name = "ID_ESTADO") // Es para indicar que es una columna de la tabla y se pueden agregar propiedades
	private Long idEstado;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ABREVIATURA")
	private String abreviatura;

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

}//FIN DE LA CLASE
