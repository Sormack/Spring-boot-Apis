package com.mx.ApiRestCinepolis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
			ipd.deleteById(idPelicula);;
			bandera = true;
		}
		return bandera;
	}
	
}































