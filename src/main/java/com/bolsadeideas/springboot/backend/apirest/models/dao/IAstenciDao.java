package com.bolsadeideas.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Astenci;


@Repository
public interface IAstenciDao extends PagingAndSortingRepository<Astenci, Long> {
	
	//VAMOS A TRAER TODAS LAS ASISTENCIAS CON PAGINACION PERO COMPAÑIA
	@Query("SELECT a FROM Astenci a WHERE a.cia = :cia")
	Page<Astenci> findAllPage(Pageable pageable,@Param("cia") String cia);
	
	List<Astenci> findByCiaAndEstado(String cia, String estado);
	
	Astenci findByCiaAndId(String cia,Long id);
	
	@Query(nativeQuery = true , value = "SELECT * FROM ASTENCI WHERE NO_CIA = :cia AND ESTADO = :estado AND COD_AS NOT IN(SELECT COD_AS FROM RGTACDE WHERE NO_CIA = :cia AND USUARIO = :user AND FECHA BETWEEN TO_DATE(:f1, 'DD/MM/YYYY HH24:MI:SS') AND TO_DATE(:f2, 'DD/MM/YYYY HH24:MI:SS'))")
	List<Astenci> finByHoyFromAstenci(@Param("cia") String cia, @Param("estado") String estado, @Param("user") String user,@Param("f1") String f1,@Param("f2") String f2);

}
