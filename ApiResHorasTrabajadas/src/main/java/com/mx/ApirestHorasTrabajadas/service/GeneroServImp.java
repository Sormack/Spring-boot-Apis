package com.mx.ApirestHorasTrabajadas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApirestHorasTrabajadas.entity.Genero;
import com.mx.ApirestHorasTrabajadas.repository.GeneroRepository;

@Service
public class GeneroServImp {
	@Autowired
	GeneroRepository generoRepository;
	
	//Mostrar lista de generos 
	@Transactional(readOnly = true)
	public List<Genero> mostraGeneros (){
		return generoRepository.findAll();
	}
	
	
}
