package com.mx.ApiRestAgencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestAgencia.entity.Marcas;
import com.mx.ApiRestAgencia.service.MarcaServImp;

@RestController
@RequestMapping(path= "marcas")
@CrossOrigin
public class MarcasWebServices {
	@Autowired
	MarcaServImp marcaServImp;
	
	
	@GetMapping(path = "mostrar")
	public List<Marcas> mostrarMarcas(){
		return marcaServImp.listar();
	}
	
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Marcas marca) {
		String response = marcaServImp.guardarMarca(marca);
		if(response == "marcaRepetida") {
			return new ResponseEntity<>("Marca Existente ", HttpStatus.OK);
		}else if(response == "nombreRepetido") {
			return new ResponseEntity<>("Nombre Existente ", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Guardado con exito ", HttpStatus.OK);
		}
	}

	@PostMapping(path = "buscar")
	public ResponseEntity<?> buscar(@RequestBody Marcas marca) {
		Marcas response = marcaServImp.buscaraXid(marca.getIdMarca());
		if(response !=null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("El id no existe ", HttpStatus.OK);
		}
	}
	
	@PostMapping(path = "editar")
	public ResponseEntity<?> editarMarca(@RequestBody Marcas marca) {
		Marcas response = marcaServImp.buscaraXid(marca.getIdMarca());
		if(response !=null) {
			return new ResponseEntity<>(marcaServImp.editarMarca(marca), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("El id no existe ", HttpStatus.OK);
		}
	}
	
	@PostMapping(path = "eliminar")
	public ResponseEntity<?> eliminarMarca(@RequestBody Marcas marca) {
		Marcas response = marcaServImp.buscaraXid(marca.getIdMarca());
		if(response !=null) {
			marcaServImp.elimarXid(marca.getIdMarca());
			return new ResponseEntity<>("Marca eliminada", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("El id no existe ", HttpStatus.OK);
		}
	}
	
	
	
	
}






























