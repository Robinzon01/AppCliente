package com.bolsadeideas.springboot.backend.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IGelocationDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Gelocation;


@Service
public class GelocationServImple implements IGelocationService {
	@Autowired
	private IGelocationDao geloDao;

	@Override
	public Gelocation searchGeloCiaAnaUsu(String cia, String user) {
		// TODO Auto-generated method stub
		return geloDao.findByCiaAndUsuario(cia, user);
	}

	@Override
	public Gelocation updateGelocation(Long id, Gelocation gelocation) {
		Gelocation newGelo = geloDao.findById(id).orElse(null);
		newGelo.setLatitud(gelocation.getLatitud());
		newGelo.setLongitud(gelocation.getLongitud());
		newGelo.setDireccion(gelocation.getDireccion());
		newGelo.setUrbanizacion(gelocation.getUrbanizacion());
		newGelo.setDni(gelocation.getDni());
		newGelo.setCodEmp(gelocation.getCodEmp());
		return geloDao.save(newGelo);
	}
	
}
