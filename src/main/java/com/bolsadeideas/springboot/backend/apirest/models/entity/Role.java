package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ROLES")
public class Role implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	//  AUTHORITY
	private String authority;
	/* *****	
	@JsonIgnoreProperties({"roles"})
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}


	private static final long serialVersionUID = 1L;
}
