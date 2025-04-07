package com.mx.ApirestHorasTrabajadas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApirestHorasTrabajadas.entity.Trabajos;
import com.mx.ApirestHorasTrabajadas.service.TrabajosServImp;
@RestController
@RequestMapping(path = "trabajos")
@CrossOrigin
public class TrabajosWebServ {

	@Autowired
	TrabajosServImp taTrabajosServImp;
	
	@GetMapping(path = "listarTrabajos")
	public List<Trabajos> listraTrabajos(){
		return taTrabajosServImp.mostrarTrabajos();
	}
	
}
