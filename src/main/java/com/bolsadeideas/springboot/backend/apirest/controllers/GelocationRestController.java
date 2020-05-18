package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Gelocation;
import com.bolsadeideas.springboot.backend.apirest.models.services.IGelocationService;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api/gelo")
public class GelocationRestController {
	@Autowired
	private IGelocationService geloService;
	
	@GetMapping(value = "/get/{cia}/{user}")
	@Secured("ROLE_USER")	
    public ResponseEntity<?> show(@PathVariable("cia") String cia, @PathVariable("user") String user) {
		
		Gelocation gelocation = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			gelocation = geloService.searchGeloCiaAnaUsu(cia, user);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(gelocation == null) {
			response.put("mensaje","El user ("+user+") con el company ("+cia+") no existe en la tabla Gelocataon.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Gelocation>(gelocation, HttpStatus.OK);
	}
}
