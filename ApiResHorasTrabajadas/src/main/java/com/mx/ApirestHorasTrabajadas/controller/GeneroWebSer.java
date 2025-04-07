package com.mx.ApirestHorasTrabajadas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApirestHorasTrabajadas.entity.Genero;
import com.mx.ApirestHorasTrabajadas.service.GeneroServImp;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "genero")
@CrossOrigin
public class GeneroWebSer {
	@Autowired
	GeneroServImp generoServImp;
	
	@GetMapping(path = "listarGeneros")
	public List<Genero> mostrarGeneros() {
		return generoServImp.mostraGeneros();
	}
	
	
}
