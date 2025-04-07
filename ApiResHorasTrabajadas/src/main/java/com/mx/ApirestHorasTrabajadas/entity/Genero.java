package com.mx.ApirestHorasTrabajadas.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*CREATE TABLE GENERO(
	    ID_GENERO NUMBER PRIMARY KEY NOT NULL,
	    NOMBRE VARCHAR2(20) NOT NULL
	);*/

@Entity
@Table(name = "GENERO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genero {
	@Id
	@Column(name ="ID_GENERO")
	private Integer idGenero;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	//Cardinalidad un genero tiene muchos empleados 
	@OneToMany(mappedBy = "genero",cascade =CascadeType.ALL)
	@JsonIgnore 
	List<Empleados> listaEmpleados = new ArrayList<>();
	
}




















