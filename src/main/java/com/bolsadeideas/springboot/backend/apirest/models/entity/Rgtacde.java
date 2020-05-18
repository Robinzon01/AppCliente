package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Rgtacde implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cod_ra")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_as")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Astenci astenci;
	
	@Size(min=1, max=50, message="La longuitud del longuitud de la tabla RGTACDE es 50.")
	private String longuitud;
	
	@Size(min=1, max=50, message="La longuitud del latitud de la tabla RGTACDE es 50.")
	private String latitud;
	
	@Size(min=1, max=20, message="La longuitud del usuario de la tabla RGTACDE es 20.")
	private String usuario;
	
	@Column(name = "no_cia")
	@Size(min=1, max=3, message="La longuitud del no_cia de la tabla RGTACDE es 3.")
	private String cia;
	
	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Astenci getAstenci() {
		return astenci;
	}

	public void setAstenci(Astenci astenci) {
		this.astenci = astenci;
	}

	public String getLonguitud() {
		return longuitud;
	}

	public void setLonguitud(String longuitud) {
		this.longuitud = longuitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCia() {
		return cia;
	}

	public void setCia(String cia) {
		this.cia = cia;
	}
	
}
