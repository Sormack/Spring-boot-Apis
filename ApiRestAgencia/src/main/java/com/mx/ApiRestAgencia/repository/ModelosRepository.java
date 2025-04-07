package com.mx.ApiRestAgencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ApiRestAgencia.entity.Marcas;
import com.mx.ApiRestAgencia.entity.Modelos;

public interface ModelosRepository extends JpaRepository<Marcas,Integer>{

}
