package com.mx.ApiRestAgencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestAgencia.entity.Marcas;
import com.mx.ApiRestAgencia.entity.Modelos;
import com.mx.ApiRestAgencia.repository.MarcasRespository;
import com.mx.ApiRestAgencia.repository.ModelosRepository;

@Service
public class ModelosSerImp {

	@Autowired
	MarcasRespository marcasRespository;
	@Autowired
	ModelosRepository modelosRepository;

	@Transactional(readOnly = true)
	public List<Modelos> mostrar() {
		return (List<Modelos>) marcasRespository.findAll();
	}

	@Transactional
	public String guardar(Modelos modelo) {
		String respuesta = "Guardado";
		boolean banderaMarca = false;
		boolean banderaModelo = false;
		// Validacion de la llaves foraneas
		for (Marcas m : modelosRepository.findAll()) {
			if (m.getIdMarca().equals(modelo.getMarca().getIdMarca())) {
				// Que la id de la marca exista
				banderaMarca = true;
				for (Modelos mod : marcasRespository.findAll()) {
					// si el id del modelo existe
					if (mod.getIdModelo().equals(modelo.getIdModelo())) {
						respuesta = "ElIDdelmodeloexiste";
						banderaModelo = true;
						break;
					} else if (mod.getNombre().equals(modelo.getNombre())) {
						// si el nombre del modelo existe
						respuesta = "Elnombredemodeloyaexiste";
						banderaModelo = true;
						break;
					} else if (mod.getPlaca().equals(modelo.getPlaca())) {
						respuesta = "Laplacayaexiste";
						banderaModelo = true;
						break;
					}
				}
				break;
			}
		}
		if (banderaMarca == false) {
			// El id de la marca no existe
			respuesta = "ElIDdemarcanoexiste";
			banderaModelo = true;
		} else if (banderaModelo == false) {
			marcasRespository.save(modelo);
		}
		return respuesta;
	}

	@Transactional(readOnly = true)
	public Modelos buscar(Integer idMod) {
		return marcasRespository.findById(idMod).orElse(null);
	}

	@Transactional
	public String editar(Modelos modelo) {
		String respuesta = "editado";
		Marcas marcaEncontrada = modelosRepository.findById(modelo.getMarca().getIdMarca()).orElse(null);
		Modelos modeloEncontrado = marcasRespository.findById(modelo.getIdModelo()).orElse(null);

		if (marcaEncontrada != null) {
			if (modeloEncontrado != null) {
				marcasRespository.save(modelo);
			} else {
				respuesta = "IDNoExiste";
			}
		} else {
			respuesta = "IDmarcaNoExiste";
		}
		return respuesta;
	}
	
	@Transactional
	public String eliminar(Integer idModelo) {
		String respuesta ="Eliminado";
		Modelos modeloEncontrado = marcasRespository.findById(idModelo).orElse(null);
		if(modeloEncontrado != null) {
			marcasRespository.deleteById(idModelo);
		}else {
			respuesta = "IdNoExiste";
		}
		return respuesta;
	}
	
}












