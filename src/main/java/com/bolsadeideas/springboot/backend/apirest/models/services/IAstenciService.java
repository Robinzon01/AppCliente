package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Astenci;


public interface IAstenciService {
	
	List<Astenci> getAllAstenci(String cia);
	Astenci createAstenci(Astenci objAstenci);
	void deleteAstenci(String cia,Long codigo);
	//BUSCAMOS UNA COMPAÑIA
	Astenci findAstenci(String cia,Long id);
	//PAGINACION
	Page<Astenci> findAllPage(Pageable pageable,String cia);
	// ASISTENCIAS QUE AUN NO SE REGISTRO
	List<Astenci> findAllAstenciFromHoy(String cia, String usuario);

}
