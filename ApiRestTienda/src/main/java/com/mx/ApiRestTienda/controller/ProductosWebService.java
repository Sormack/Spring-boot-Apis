package com.mx.ApiRestTienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestTienda.model.Productos;
import com.mx.ApiRestTienda.service.ProductosServicioImolmp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




//Una Web service permite la comunicacion de dos diferentes lenguajes
//Arquitectura cliente servidor ---cliente y el servidor 
//WebService de tipo res --JSON es un formato de texto plano 

@RestController
@RequestMapping(path = "ProductosWebService")
@CrossOrigin
//Aqui se invocan los metodos para las peticiones  
public class ProductosWebService {
	//@RestController Permite marcar como controlador de solicitudes y se usa para crear 
	//Servicos de tipo res ---rest full y para la creacion de WebService de tipo rest
	//@RequestMapping Permite formar los recusrsos o las URL para poder acceder a las peticiones 
	//@CrossOrigin Sirve para seguridad para que la aplicacion no sea bloqueada por el navegador 
	
	//Inyeccion de dependencia 
	@Autowired
	ProductosServicioImolmp productosServicioImolmp;
	
	//Peticiones de tipo get,post,put,delete
	//URL:Utiliza el protocolo http
	//La formacion de la url : urlServidorLocal/pathClase/pathMetodo
	//http://localhost:9000/ProductosWebService/listar
	
	@GetMapping(path = "listar")
	public List<Productos> listar() {
		return productosServicioImolmp.mostrar();
	}
	
	//http://localhost:9000/ProductosWebService/guardar
	//@RequestBody --Convierte el json a objeto
	@PostMapping(path="guardar")
	public ResponseEntity<?> guardar(@RequestBody Productos producto) {
		String response = productosServicioImolmp.guardar(producto);
		if(response.equals("CodigoExistente")) {
			return new ResponseEntity<>("Codigo de barra existente", HttpStatus.OK);
		}else if(response.equals("nombreExistente")) {
			return new ResponseEntity<>("Nombre ya existente",HttpStatus.OK);
		}else {
			return new ResponseEntity<>(producto, HttpStatus.CREATED);
		}
	}
	
	//http://localhost:9000/ProductosWebService/buscarId

	@PostMapping(path = "buscarId")
	public Productos buscarXid(@RequestBody Productos producto) {
		return productosServicioImolmp.buscaraXid(producto.getIdProduct());
	}
	
	@PutMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Productos producto){
		boolean response = productosServicioImolmp.editar(producto);
		if(response == false) {
			return new ResponseEntity<>("Registro no existente", HttpStatus.OK);
		}else {
			return new ResponseEntity<>(producto, HttpStatus.OK);
		}
	}
	
	@PostMapping(path = "eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Productos producto){
		boolean response = productosServicioImolmp.eliminar(producto.getIdProduct());
		if(response == false) {
			return new ResponseEntity<>("Registro no existente", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Eliminado con exito", HttpStatus.OK);
		}
	}
	
	//http://localhost:9000/ProductosWebService/buscarId/sabritas

	@GetMapping(path = "buscar/{nombre}")
	public Productos buscarXnombre(@PathVariable("nombre") String nombre) {
		return productosServicioImolmp.buscarXNombre(nombre);
	}
	
	@GetMapping(path = "buscarPrecio")
	public List<Productos> buscarXprecio(@RequestBody Productos producto) {
		return productosServicioImolmp.buscarXprecio(producto.getPrecio());
	}
	
}





























