package com.bolsadeideas.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Company;


@Repository
public interface ICompanyDao extends PagingAndSortingRepository<Company, String> {
	Company findByCia(String cia);
}
