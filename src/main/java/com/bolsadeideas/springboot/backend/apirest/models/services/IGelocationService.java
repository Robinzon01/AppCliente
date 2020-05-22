package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Gelocation;

public interface IGelocationService {
	Gelocation searchGeloCiaAnaUsu(String cia, String user);
	Gelocation updateGelocation(Long id, Gelocation gelocation);
}
