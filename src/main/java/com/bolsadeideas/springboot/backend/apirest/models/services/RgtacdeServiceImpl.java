package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IRgtacdeDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Rgtacde;


@Service
public class RgtacdeServiceImpl implements IRgtacdeService {
	
	@Autowired
	private IRgtacdeDao rgDao;

	@Override
	public List<Rgtacde> getAllRgtacde() {
		List<Rgtacde> rgs = new ArrayList<Rgtacde>();
		rgDao.findAll().iterator().forEachRemaining(rgs :: add);
		return rgs;
	}

	@Override
	public Rgtacde createRgtacde(Rgtacde objRgtacde) {
		return rgDao.save(objRgtacde);
	}

	@Override
	public void deleteRgtacde(Long codigo) {
		rgDao.delete(findRgtacde(codigo));
	}

	@Override
	public Rgtacde findRgtacde(Long codigo) {
		Optional<Rgtacde> rg = rgDao.findById(codigo);
		return rg.get();
	}

	@Override
	public Page<Rgtacde> findAllPage(Pageable pageable, String cia) {
		return rgDao.findAllPage(pageable, cia);
	}

	@Override
	public List<Rgtacde> registroHoyAndUser(String cia,String user) {
		
		Calendar calendario = new GregorianCalendar();
		int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        
        String f1 = dia+"/"+(mes+1)+"/"+ano+" 00:00:00";
        String f2 = dia+"/"+(mes+1)+"/"+ano+" 23:59:59";
        
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
		List<Rgtacde> rgs= new ArrayList<>();
		
		try {
			// System.out.println(formato.parse(f1) + " ::: "+formato.parse(f2));
			rgDao.findByCiaAndUserAndFecha(cia,user, formato.parse(f1) , formato.parse(f2) ).iterator().forEachRemaining(rgs :: add);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rgs;
		
	}
	
}
