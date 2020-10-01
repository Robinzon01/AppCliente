package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.bolsadeideas.springboot.backend.apirest.models.entity.Rgtacde;
import com.bolsadeideas.springboot.backend.apirest.models.services.IRgtacdeService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api/rgta")
public class RgtacdeRestController {
	
	@Autowired
	private IRgtacdeService rgtaService;
	
	//METODO POST
	@PostMapping("/save")
	@Secured("ROLE_USER")
    public ResponseEntity<?> create(@Valid @RequestBody Rgtacde objRg, BindingResult result) {
		
		Rgtacde rgtacdeNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			rgtacdeNew = rgtaService.createRgtacde(objRg);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  
		response.put("mensaje", "La asistencia ha sido creado con éxito!");
		response.put("rgtacde", rgtacdeNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
    @GetMapping(value = "/rgHoy/{cia}/{user}")
	@Secured("ROLE_USER")
	public List<Rgtacde> registroHoy(@PathVariable("cia") String cia, @PathVariable("user") String user) {
		return rgtaService.registroHoyAndUser(cia, user); 
	}
    //METODO QUE ENVIA UNA PAGINACION DE RGTACDE
  	@GetMapping("/list/page/{cia}/{page}")
  	@Secured("ROLE_ADMIN")
  	public Page<Rgtacde> paginacion(@PathVariable("cia") String cia, @PathVariable("page") Integer page ){
  		Pageable pageable = PageRequest.of(page, 4);
  		return rgtaService.findAllPage(pageable, cia);
  	}

}
