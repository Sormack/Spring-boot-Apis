package com.mx.ApiRestTienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestTienda.dao.ProductosDao;
import com.mx.ApiRestTienda.model.Productos;

//@Service es un estereotipo o anotacion para indicar que vamos a realizar un servicio 
@Service
//Aqi va toda la logica de la los metos 
public class ProductosServicioImolmp {
	//Inyeccion de dependencia--permite acceso a todo lo que contenga esa clase o interface 
	//@Autowired  ---Permite un mejor control de los objetos que se inicializan 
	@Autowired
	ProductosDao productosDao;
	
	@Transactional(readOnly = true)
	
	public List<Productos> mostrar(){
		List<Productos> registrosBd = productosDao.findAll();
		return registrosBd;
	}
	
	@Transactional
	public String guardar(Productos producto) {
		String respuesta = "Guardado";
		boolean bandera = false;
		for(Productos p: productosDao.findAll()) {
			if(p.getCodigoBarra().equals(producto.getCodigoBarra())) {
				respuesta = "CodigoExistente";
				bandera = true;
				break;
			}else if(p.getNombre().equals(producto.getNombre())) {
				respuesta = "nombreExistente";
				bandera =  true;
				break;
			}
		}
		if(!bandera) {
			productosDao.save(producto);
		}
		return respuesta;
	}
	
	@Transactional(readOnly = true)
	public Productos buscaraXid(Integer idProducto) {
		Productos productoEncontrado = productosDao.findById(idProducto).orElse(null);
		return productoEncontrado;
	}
	
	
	//validacion del que id exista
	@Transactional
	public boolean editar(Productos producto) {
		Productos productoEncontrado = productosDao.findById(producto.getIdProduct()).orElse(null);
		boolean bandera = false;
		if(productoEncontrado !=null) {
			productosDao.save(producto);
			bandera = true;
		}
		return bandera;
	}
	
	@Transactional
	public boolean eliminar(Integer idProd) {
		Productos productoEncontrado = productosDao.findById(idProd).orElse(null);
		boolean bandera = false;
		if(productoEncontrado !=null) {
			productosDao.deleteById(idProd);;
			bandera = true;
		}
		return bandera;
	}
	@Transactional(readOnly = true )
	public Productos buscarXNombre(String nombre) {
		return productosDao.findByNombre(nombre);
	}
	@Transactional(readOnly = true)
	public List<Productos> buscarXprecio(Float precio){
		return productosDao.buscarXprecio(precio);
	}
}




























