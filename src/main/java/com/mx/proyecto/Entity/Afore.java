package com.mx.proyecto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AFORE", schema = "CAPACITACION1")
public class Afore {
	
	@Id // Es para indicarle que el campo/atributo va ser un id,tambien suele ser la llave primaria
	@Column(name = "ID_TRABAJADOR", unique = true, nullable = false, precision = 10) // Es para indicar que es una columna de la tabla y se pueden agregar propiedades
	private Long idTrabajador;
	
	@Column(name = "ANIO")
	private int anio;
	
	@Column(name = "MES")
	private int mes;
	
	@Column(name = "NSS")
	private long nss;
	
	@Column(name = "CURP")
	private String curp;
	
	@Column(name = "ESTATUS_ACTIVIDAD")
	private int estatusActividad;
	
	@Column(name = "TIPO_TRABAJADOR")
	private int tipoTrabajador;
	
	@Column(name = "ESTATUS_CUENTA")
	private int estatusCuenta;
	
	@Column(name = "CODIGO_ORIGEN")
	private int codigoOrigen;
	
	@Column(name = "REGIMEN_AFILIACION")
	private int regimenAfiliacion;
	
	@Column(name = "INDICADOR_SALDO")
	private int indicadorSaldo;

	public Long getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(Long idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public long getNss() {
		return nss;
	}

	public void setNss(long nss) {
		this.nss = nss;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public int getEstatusActividad() {
		return estatusActividad;
	}

	public void setEstatusActividad(int estatusActividad) {
		this.estatusActividad = estatusActividad;
	}

	public int getTipoTrabajador() {
		return tipoTrabajador;
	}

	public void setTipoTrabajador(int tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}

	public int getEstatusCuenta() {
		return estatusCuenta;
	}

	public void setEstatusCuenta(int estatusCuenta) {
		this.estatusCuenta = estatusCuenta;
	}

	public int getCodigoOrigen() {
		return codigoOrigen;
	}

	public void setCodigoOrigen(int codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}

	public int getRegimenAfiliacion() {
		return regimenAfiliacion;
	}

	public void setRegimenAfiliacion(int regimenAfiliacion) {
		this.regimenAfiliacion = regimenAfiliacion;
	}

	public int getIndicadorSaldo() {
		return indicadorSaldo;
	}

	public void setIndicadorSaldo(int indicadorSaldo) {
		this.indicadorSaldo = indicadorSaldo;
	}

	

}
