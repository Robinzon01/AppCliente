package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SIEA_COMPANIA")
public class Company implements Serializable {
	
	@Id
	@Column(name="NO_CIA")
	private String cia;
	
	@Size(min=1, max=200, message="La longuitud del nombre de la compañia es 30.")
	@Column(name="NOM_CIA")
	private String nombre;
	
	@Column(name="NOM_CIA_CORTO")
	private String nombreAno;
	
	@Size(min=1, max=11)
	private String ruc;
	
	@Column(name="RAZON_SOCIAL")
	private String razonSocial;
	
	@Column(name="NRO_LICENCIA")
	private String licencia;

	public String getCia() {
		return cia;
	}

	public void setCia(String cia) {
		this.cia = cia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreAno() {
		return nombreAno;
	}

	public void setNombreAno(String nombreAno) {
		this.nombreAno = nombreAno;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	
	private static final long serialVersionUID = 1L;
	
}
