package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Company;


public interface ICompanyService {
	
	List<Company> getAllCompany();
	Company createCompany(Company objC);
	void deleteCompany(String cia);
	//BUSCAMOS UNA COMPAÑIA
	Company findCompany(String cia);
	//PAGINACION
	Page<Company> findAll(Pageable pageable);

}
