package com.bolsadeideas.springboot.backend.apirest.models.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Rgtacde;

@Repository
public interface IRgtacdeDao extends PagingAndSortingRepository<Rgtacde, Long> {
	
	//VAMOS A TRAER TODOS LOS REGISTRO DE ACTIVIDADES PERO COMPAÑIA
	@Query("SELECT r FROM Rgtacde r WHERE r.cia = :cia ORDER BY r.fecha DESC")
	Page<Rgtacde> findAllPage(Pageable pageable,@Param("cia") String cia);
	
	@Query("SELECT a FROM Rgtacde a WHERE a.cia = :cia AND a.usuario = :user AND a.fecha BETWEEN :f1 AND :f2")
	List<Rgtacde> findByCiaAndUserAndFecha(@Param("cia") String cia, @Param("user") String user ,@Param("f1") Date f1,@Param("f2") Date f2);
    
}
