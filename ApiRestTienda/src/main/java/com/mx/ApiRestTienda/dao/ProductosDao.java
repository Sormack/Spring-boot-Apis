package com.mx.ApiRestTienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ApiRestTienda.model.Productos;

//JpaRepository contiene la paginacion y CrudRepository
//Viene de la dependencia de Spring Data,ya  contiene los metodos del crud 
public interface ProductosDao extends JpaRepository<Productos, Integer>{
	
}
