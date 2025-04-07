package com.mx.ApiRestTienda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.ApiRestTienda.model.Productos;

//JpaRepository contiene la paginacion y CrudRepository
//Viene de la dependencia de Spring Data,ya  contiene los metodos del crud 
public interface ProductosDao extends JpaRepository<Productos, Integer>{
	//Resorte de los repositorio ----findBy----agregar  el atrbibuto(el atributo debe de ser igual al mapeo) para buscar
	//Metodo para buscar por el nombre 
	public Productos findByNombre(String nombre);
	
	//Buscar producto x precio 
	@Query(value= "SELECT * FROM PRODUCTOS_PATITO WHERE PRECIO = PRECIO",nativeQuery = true)
	public List<Productos> buscarXprecio(@Param("PRECIO") Float precio);
	
}
