package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IAstenciDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Astenci;

@Service
public class AstenciServiceImpl implements IAstenciService {
	
	@Autowired
	private IAstenciDao asteDao;
	
	@Override
	public List<Astenci> getAllAstenci(String cia) {
		List<Astenci> ass = new ArrayList<Astenci>();
		asteDao.findByCiaAndEstado(cia, "S").iterator().forEachRemaining(ass :: add);
		return ass;
	}

	@Override
	public Astenci createAstenci(Astenci objAstenci) {
		return asteDao.save(objAstenci);
	}

	@Override
	public void deleteAstenci(String cia,Long codigo) {
		asteDao.delete(findAstenci(cia,codigo));
	}

	@Override
	public Astenci findAstenci(String cia,Long codigo){
		return asteDao.findByCiaAndId(cia, codigo);
	}

	@Override
	public Page<Astenci> findAllPage(Pageable pageable, String cia) {
		return asteDao.findAllPage(pageable, cia);
	}

	@Override
	public List<Astenci> findAllAstenciFromHoy(String cia, String usuario) {
		Calendar calendario = new GregorianCalendar();
		int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        
        String f1 = dia+"/"+(mes+1)+"/"+ano+" 00:00:00";
        String f2 = dia+"/"+(mes+1)+"/"+ano+" 23:59:59";
        List<Astenci> ass = new ArrayList<>();
        asteDao.finByHoyFromAstenci(cia, "S", usuario, f1, f2).iterator().forEachRemaining(ass :: add);
       return ass;
	}


}
