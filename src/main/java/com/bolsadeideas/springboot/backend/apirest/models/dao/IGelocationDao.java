package com.bolsadeideas.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Gelocation;


@Repository
public interface IGelocationDao extends CrudRepository<Gelocation,Long> {
	// VAMOS A BUSCAR POR USUARIO Y COMPAÑIA
	Gelocation findByCiaAndUsuario(String cia, String usu);
}
