package com.mx.ApiRestAgencia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestAgencia.entity.Marcas;
import com.mx.ApiRestAgencia.repository.ModelosRepository;

@Service
public class MarcaServImp {

	@Autowired
	ModelosRepository modelosRepository;

	// Mostar marcas
	@Transactional(readOnly = true)
	public List<Marcas> listar() {
		List<Marcas> listaMarcas = new ArrayList<>();
		listaMarcas = modelosRepository.findAll();
		return listaMarcas;
	}

	// Guardar nueva marca
	@Transactional
	public String  guardarMarca(Marcas marca) {
		String existente = "";
		boolean bandera = false;
		for (Marcas m : modelosRepository.findAll()) {
			if (m.getIdMarca().equals(marca.getIdMarca())) {
				existente = "marcaRepetida";
				bandera = true;
				break;
			} else if (m.getNombre().equals(marca.getNombre())) {
				existente= "nombreRepetido";
				bandera = true;
				break;
			}
			if (bandera == false) {
				modelosRepository.save(marca);
			}
		}
		return existente;
	}
	
	//Buscar por id
	@Transactional(readOnly = true)
	public Marcas buscaraXid(Integer idMarca) {
		Marcas marcaEncontrada = modelosRepository.findById(idMarca).orElse(null);
		return marcaEncontrada;
	}
	
	//Editar por id
	@Transactional
	public Marcas editarMarca(Marcas marca) {
		return modelosRepository.save(marca);	
	}
	
	//Eliminar por id
	@Transactional
	public void elimarXid(Integer idMarca) {
		modelosRepository.deleteById(idMarca);
	}
	
}


























