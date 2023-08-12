package com.mx.proyecto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // ANOTACION PARA INDICARLE QUE ESTA CLASE VA A SER UNA ENTITY
@Table(name = "ANIO", schema = "CAPACITACION1") // Anotacion table donde indicamos el nombre de la tabla y el esquema
public class AnioEntity {
	
	@Id // Es para indicarle que el campo/atributo va ser un id,tambien suele ser la llave primaria
	@Column(name = "ID_ANIO", unique = true, nullable = false, precision = 3) // Es para indicar que es una columna de la tabla y se pueden agregar propiedades
	private Long idAnio;
	
	@Column(name = "NOMBRE_ANIO")
	private String nombreAnio;

	public Long getIdAnio() {
		return idAnio;
	}

	public void setIdAnio(Long idAnio) {
		this.idAnio = idAnio;
	}

	public String getNombreAnio() {
		return nombreAnio;
	}

	public void setNombreAnio(String nombreAnio) {
		this.nombreAnio = nombreAnio;
	}
	
	

}//FIN DE LA CLASE
