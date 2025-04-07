package com.mx.ApiRestCinepolis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestCinepolis.model.Peliculas;
import com.mx.ApiRestCinepolis.service.PeliculasImplementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "cinepolis")
@CrossOrigin
public class PeliculasWebService {
	//Se instancia la clase donde se encuntra todos los metodos 
	@Autowired
	PeliculasImplementacion pli;
	//http://localhost:9000/cinepolis/mostrar
	Peliculas pelicula = null;
	@GetMapping(path = "mostrar")
	public List<Peliculas> listaPeliculas() {
		return pli.mostrarPeliculas();
	}
	
	//http://localhost:9000/ProductosWebService/guardar
	//@RequestBody --Convierte el json a objeto
	@PostMapping(path="guardar")
	public ResponseEntity<?> guardar(@RequestBody Peliculas pelicula) {
		String response = pli.guardar(pelicula);
		if(response.equals("CodigoExistente")) {
			return new ResponseEntity<>("Codigo de barra existente", HttpStatus.OK);
		}else if(response.equals("nombreExistente")) {
			return new ResponseEntity<>("Nombre ya existente",HttpStatus.OK);
		}else {
			return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
		}
	}
	
	@PostMapping(path = "buscarId")
	public Peliculas buscarXid(@RequestBody Peliculas pelicula) {
		return pli.buscaraXid(pelicula.getIdPelicula());
	}
	
	@PutMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Peliculas pelicula){
		boolean response = pli.editar(pelicula);
		if(response == false) {
			return new ResponseEntity<>("Registro no existente", HttpStatus.OK);
		}else {
			return new ResponseEntity<>(pelicula, HttpStatus.OK);
		}
	}
	
	@PostMapping(path = "eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Peliculas pelicula){
		boolean response = pli.eliminar(pelicula.getIdPelicula());
		if(response == false) {
			return new ResponseEntity<>("Registro no existente", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Eliminado con exito", HttpStatus.OK);
		}
	}
	
	//http://localhost:9000/cinepolis/buscarNombre
	@PostMapping(path = "buscarNombre")
	public Peliculas buscarXnoombre(@RequestBody Peliculas pelicula) {
		return pli.buscarXnombre(pelicula.getNombre());
	}
	
	//http://localhost:9000/cinepolis/buscar/TERROR
	@GetMapping(path = "buscar/{genero}")
	public Peliculas buscarXgenero(@PathVariable ("genero") String genero) {
		return pli.buscarXgenero(genero);
	}
	@PostMapping(path = "buscar")
	public List<Peliculas> buscarPelicula(@RequestBody Peliculas pelicula) {
		return pli.buscar(pelicula);
	}
	
	@DeleteMapping(path = "elimarNombre")
	public void eliminarPelicula(@RequestBody Peliculas pelicula) {
		pli.eliminarXnombre(pelicula.getNombre());
	}
	
}














