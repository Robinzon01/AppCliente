package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Role;

public interface IRolService {
	List<Role> rolesUnicos();
}
