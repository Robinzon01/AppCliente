package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
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

import com.bolsadeideas.springboot.backend.apirest.models.entity.Astenci;
import com.bolsadeideas.springboot.backend.apirest.models.services.IAstenciService;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api/asten")
public class AstenciRestController {
	
	@Autowired
	private IAstenciService asteService;
	
    @GetMapping(value = "/list/{cia}")
	@Secured("ROLE_USER")
    public List<Astenci> listar(@PathVariable("cia") String cia) {
		return asteService.getAllAstenci(cia); 
	}
	
    @GetMapping(value = "/asHoy/{cia}/{user}")
	@Secured("ROLE_USER")
	public List<Astenci> registroHoy(@PathVariable("cia") String cia, @PathVariable("user") String user) {
		return asteService.findAllAstenciFromHoy(cia, user); 
	}
    
    @GetMapping(value = "/aste/{cia}/{id}")
	@Secured("ROLE_USER")
    public ResponseEntity<?> getAstenci(@PathVariable("cia") String cia,@PathVariable("id") Long id){
    	Astenci aste = null;
    	Map<String, Object> response = new HashMap<>();
    	try{
    		aste = asteService.findAstenci(cia, id);
    	}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage())  );
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	if(aste == null) {
    		response.put("mensaje", "El ID ".concat(id.toString().concat(" no existe en la base de datos!!"))  );
    		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<Astenci>(aste,HttpStatus.OK);
    }
    
}
