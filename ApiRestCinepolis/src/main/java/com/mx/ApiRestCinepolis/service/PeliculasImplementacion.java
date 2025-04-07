package com.mx.ApiRestCinepolis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.ApiRestCinepolis.dao.PeliculasDao;
import com.mx.ApiRestCinepolis.model.Peliculas;

@Service
public class PeliculasImplementacion {
	//Se manda a llamar la interface de PeliculasDao
	
	@Autowired
	PeliculasDao ipd;
	@Transactional(readOnly = true)
	
	//Metodo para mostrar todos los registros disponibles en la tabla de peliculas 
	public List<Peliculas> mostrarPeliculas(){
		List<Peliculas> listaPeliculas = ipd.findAll();
		return listaPeliculas;
	}
	
	@Transactional
	public String guardar(Peliculas pelicula) {
		String respuesta = "Guardado";
		boolean bandera = false;
		for(Peliculas p: ipd.findAll()) {
			if(p.getIdPelicula().equals(pelicula.getIdPelicula())) {
				respuesta = "CodigoExistente";
				bandera = true;
				break;
			}else if(p.getNombre().equals(pelicula.getNombre())) {
				respuesta = "nombreExistente";
				bandera =  true;
				break;
			}
		}
		if(!bandera) {
			ipd.save(pelicula);
		}
		return respuesta;
	}
	
	@Transactional(readOnly = true)
	public Peliculas buscaraXid(Integer idPelicula) {
		Peliculas peliculaEncontrado = ipd.findById(idPelicula).orElse(null);
		return peliculaEncontrado;
	}
	
	
	//validacion del que id exista
	@Transactional
	public boolean editar(Peliculas pelicula) {
		Peliculas peliculaEncontrado = ipd.findById(pelicula.getIdPelicula()).orElse(null);
		boolean bandera = false;
		if(peliculaEncontrado !=null) {
			ipd.save(pelicula);
			bandera = true;
		}
		return bandera;
	}
	
	@Transactional
	public boolean eliminar(Integer idPelicula) {
		Peliculas peliculaEncontrado = ipd.findById(idPelicula).orElse(null);
		boolean bandera = false;
		if(peliculaEncontrado !=null) {
			ipd.deleteById(idPelicula);
			bandera = true;
		}
		return bandera;
	}
	
	@Transactional
	public Peliculas buscarXnombre(String nombre) {
		List<Peliculas> listaPeliculas = ipd.findAll();
		for(Peliculas p: listaPeliculas) {
			if(p.getNombre().equals(nombre)) {
				return p;
			}
		}
		return null;
	}
	
	@Transactional
	public Peliculas buscarXgenero(String genero) {
		List<Peliculas> listaPeliculas = ipd.findAll();
		for(Peliculas p: listaPeliculas) {
			if(p.getGenero().equals(genero)) {
				return p;
			}
		}
		return null;
	}
	
	@Transactional
	public List<Peliculas> buscar(Peliculas pelicula){
		List<Peliculas> listaPeliculasEncontradas = new ArrayList<>();
		for(Peliculas p: ipd.findAll()) {
			if(p.getNombre().equals(pelicula.getNombre())){
				listaPeliculasEncontradas.add(p);
			}else if(p.getPrecio().equals(pelicula.getPrecio())) {
				listaPeliculasEncontradas.add(p);
			}else if(p.getGenero().equals(pelicula.getGenero())) {
				listaPeliculasEncontradas.add(p);
			}
		}
		return listaPeliculasEncontradas;
	}
	
	public void eliminarXnombre(String nombre) {
		List<Peliculas> listaPeliculas = ipd.findAll();
		for(Peliculas p: listaPeliculas) {
			if(p.getNombre().equals(nombre)){
				ipd.deleteById(p.getIdPelicula());
			}
		}
	}
	
}































