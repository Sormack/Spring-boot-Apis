package com.mx.ApirestHorasTrabajadas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ApirestHorasTrabajadas.entity.Trabajos;
import com.mx.ApirestHorasTrabajadas.repository.TrabajosRepository;

@Service
public class TrabajosServImp {
	@Autowired
	TrabajosRepository trabajosRepository;
	
	//Mostrar lista de trabajos
	public List<Trabajos> mostrarTrabajos(){
		return trabajosRepository.findAll();
	}
	
}
