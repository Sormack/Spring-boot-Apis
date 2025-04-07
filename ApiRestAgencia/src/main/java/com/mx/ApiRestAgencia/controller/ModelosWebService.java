package com.mx.ApiRestAgencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestAgencia.entity.Modelos;
import com.mx.ApiRestAgencia.service.ModelosSerImp;

@RestController
@RequestMapping(path = "modelos/api/v1")
@CrossOrigin
public class ModelosWebService {

	@Autowired
	ModelosSerImp modelosSerImp;
	
	//http://localhost:9000/modelos/api/v1/listar
	@GetMapping(path = "listar")
	public List<Modelos> listar(){
		return modelosSerImp.mostrar();
	}
	
	//http://localhost:9000/modelos/api/v1/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Modelos modelo){
		String response = modelosSerImp.guardar(modelo);
		if(response.equals("ElIDdemarcanoexiste")) {
			return new ResponseEntity<>("Ese id de marca ya existe no se puede guardar",HttpStatus.OK);
		}
		if(response.equals("ElIDdelmodeloexiste")) {
			return new ResponseEntity<>("Ese id de modelo ya existe no se puede guardar",HttpStatus.OK);
		}
		
		if(response.equals("Elnombredemodeloyaexiste")) {
			return new ResponseEntity<>("Ese nombre de modelo ya existe no se puede guardar",HttpStatus.OK);
		}
		if(response.equals("Laplacayaexiste")) {
			return new ResponseEntity<>("La placa del modelo ya existe no se puede guardar",HttpStatus.OK);
		}else {
			return new ResponseEntity<>(modelo,HttpStatus.OK);
		}
		
	}
	
	@PostMapping(path = "buscar") 
	public ResponseEntity<?> buscar(@RequestBody Modelos modelo){
		Modelos nuvMod= modelosSerImp.buscar(modelo.getIdModelo());
		if(nuvMod !=null) {
			return new ResponseEntity<>(nuvMod,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No existe el ID del modelo",HttpStatus.OK);
		}
	}
	
	@PostMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Modelos modelo){
		String response = modelosSerImp.editar(modelo);
		if(response == "IDNoExiste") {
			return new ResponseEntity<>("El ID del modelo no existe",HttpStatus.OK);
		}else if(response == "IDmarcaNoExiste") {
			return new ResponseEntity<>("El ID de la marca ya existe",HttpStatus.OK);
		}else {
			return new ResponseEntity<>(modelo,HttpStatus.OK);
		}
		
	}
	
	@DeleteMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Modelos modelo){
		String response = modelosSerImp.eliminar(modelo.getIdModelo());
		if(response == "IdNoExiste") {
			return new ResponseEntity<>("El no existe",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Eliminado",HttpStatus.OK);
		}
	}
	
}





















