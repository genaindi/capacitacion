package com.mx.proyecto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Anotacion para indicarle que esta clase va a ser una entity/entidad
@Table(name = "CAT_ROLES", schema = "CAPACITACION1") // Anotacion table donde indicamos el nombre de la tabla y el esquema
public class catRoles {
	
	@Id // Es para indicarle que el campo/atributo va ser un id,tambien suele ser la llave primaria
	@Column(name = "ID_ROL") // Es para indicar que es una columna de la tabla y se pueden agregar propiedades
	private Long idRol;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}//FIN DE LA CLASE
