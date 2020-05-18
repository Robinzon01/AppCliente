package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.backend.apirest.models.dao.ICompanyDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Company;


@Service
public class CompanyServImple implements ICompanyService {
	
	@Autowired
	private ICompanyDao arfamcDao;

	@Override
	public List<Company> getAllCompany() {
		List<Company> cias = new ArrayList<>();
		arfamcDao.findAll().iterator().forEachRemaining(cias::add);
		return cias;
	}

	@Override
	public Company createCompany(Company objArfamc) {
		// TODO Auto-generated method stub
		return arfamcDao.save(objArfamc);
	}

	@Override
	public void deleteCompany(String cia) {
		// TODO Auto-generated method stub
		 arfamcDao.delete( this.findCompany(cia) );
	}

	@Override
	public Company findCompany(String cia) {
		// TODO Auto-generated method stub
		return arfamcDao.findByCia(cia);
	}

	@Override
	public Page<Company> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
