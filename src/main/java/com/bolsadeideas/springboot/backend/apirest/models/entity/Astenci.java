package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Astenci implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_as")
	private Long id;
	
	@Size(min=1, max=50, message="La longuitud del nombre de la tabla ASTENCI es 50.")
	private String nombre;
	
	@Size(min=1, max=1, message="La longuitud del estado de la tabla ASTENCI es 1.")
	private String estado;
	
	@Size(min=1, max=100, message="La longuitud del foto de la tabla ASTENCI es 100.")
	private String foto;
	
	@Column(name = "no_cia")
	@Size(min=1, max=3, message="La longuitud del no_cia de la tabla ASTENCI es 3.")
	private String cia;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCia() {
		return cia;
	}

	public void setCia(String cia) {
		this.cia = cia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
