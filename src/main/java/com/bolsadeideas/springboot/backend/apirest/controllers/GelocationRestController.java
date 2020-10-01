package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Gelocation gelocation, BindingResult result,
			@PathVariable Long id) {
		Gelocation newGelo = null;
		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (gelocation == null) {
			response.put("mensaje", "Error: no se pudo editar, el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			newGelo = geloService.updateGelocation(id, gelocation);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la geolocalización en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La geolocalización ha sido actualizado con éxito!");
		response.put("gelocalizacion", newGelo);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
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
