package com.mx.proyecto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // ANOTACION PARA INDICARLE QUE ESTA CLASE VA A SER UNA ENTITY
@Table(name = "ESTATUS_CUENTA_IND", schema = "CAPACITACION1") // Anotacion table donde indicamos el nombre de la tabla y el esquema
public class EstatusCuentaEntity {
	
	@Id // Es para indicarle que el campo/atributo va ser un id,tambien suele ser la llave primaria
	@Column(name = "ID_CUENTA_I", unique = true, nullable = false, precision = 3) // Es para indicar que es una columna de la tabla y se pueden agregar propiedades
	private Long idCuentaInd;
	
	@Column(name = "ESTATUS_CUENTA")
	private String estatusCuenta;

	public Long getIdCuentaInd() {
		return idCuentaInd;
	}

	public void setIdCuentaInd(Long idCuentaInd) {
		this.idCuentaInd = idCuentaInd;
	}

	public String getEstatusCuenta() {
		return estatusCuenta;
	}

	public void setEstatusCuenta(String estatusCuenta) {
		this.estatusCuenta = estatusCuenta;
	}
	
	

}//FIN DE LA CLASE
