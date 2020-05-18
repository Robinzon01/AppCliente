package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Rgtacde;


public interface IRgtacdeService {
	
	List<Rgtacde> getAllRgtacde();
	Rgtacde createRgtacde(Rgtacde objRgtacde);
	void deleteRgtacde(Long codigo);
	//BUSCAMOS UNA COMPAÑIA
	Rgtacde findRgtacde(Long codigo);
	//PAGINACION
	Page<Rgtacde> findAllPage(Pageable pageable,String cia);
	
	//METODO QUE NOS PERMITE TRAER LOS REGISTRO DE LA FECHA DE HOY
	List<Rgtacde> registroHoyAndUser(String cia,String user);
}
