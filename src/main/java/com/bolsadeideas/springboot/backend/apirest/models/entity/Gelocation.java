package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
public class Gelocation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_ge")
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "no_cia")
	@Size(min=1, max=3, message="La longuitud del no_cia de la tabla Gelocation es 3.")
	private String cia;
	
	@Size(min=1, max=50, message="La longuitud del usuario de la tabla Gelocation es 50.")
	private String usuario;
	
	@Column(name = "cod_empleado")
	@Size(min=1, max=20, message="La longuitud del cod_empleado de la tabla Gelocation es 20.")
	private String codEmp;
	
	@Size(min=1, max=8, message="La longuitud del dni de la tabla Gelocation es 8.")
	private String dni;
	
	@Size(min=1, max=50, message="La longuitud del longitud de la tabla Gelocation es 50.")
	private String longitud;
	
	@Size(min=1, max=50, message="La longuitud del latitud de la tabla Gelocation es 50.")
	private String latitud;
	
	@Size(min=1, max=200, message="La longuitud del direccion de la tabla Gelocation es 200.")
	private String direccion;
	
	@Size(min=1, max=6, message="La longuitud del ubigeo de la tabla Gelocation es 6.")
	private String ubigeo;
	
	@Size(min=1, max=100, message="La longuitud del urbanizacion de la tabla Gelocation es 100.")
	private String urbanizacion;
	
	@Size(min=1, max=1, message="La longuitud del estado de la tabla Gelocation es 1.")
	private String estado;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "F_CREACION")
	private Date fInactivo;
	/*
	@Size(min=1, max=50, message="La longuitud del uCreacion de la tabla Gelocation es 50.")
	@Column(name = "U_CREACION")
	private String uCreacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "F_CREACION")
	private Date fCreacion;
	
	@PrePersist
	public void prePersist() {
		fCreacion = new Date();
	}
	*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCia() {
		return cia;
	}

	public void setCia(String cia) {
		this.cia = cia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(String codEmp) {
		this.codEmp = codEmp;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

	public String getUrbanizacion() {
		return urbanizacion;
	}

	public void setUrbanizacion(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getfInactivo() {
		return fInactivo;
	}

	public void setfInactivo(Date fInactivo) {
		this.fInactivo = fInactivo;
	}
	/*
	public String getuCreacion() {
		return uCreacion;
	}

	public void setuCreacion(String uCreacion) {
		this.uCreacion = uCreacion;
	}

	public Date getfCreacion() {
		return fCreacion;
	}

	public void setfCreacion(Date fCreacion) {
		this.fCreacion = fCreacion;
	}
	*/
}
