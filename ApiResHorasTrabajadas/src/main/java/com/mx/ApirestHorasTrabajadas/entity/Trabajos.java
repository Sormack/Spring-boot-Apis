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

/*CREATE TABLE TRABAJOS(
    ID_TRABAJO NUMBER PRIMARY KEY NOT NULL,
    NOMBRE VARCHAR2(255)NOT NULL,
    SALARIO NUMBER(9,2)NOT NULL
);*/

@Entity
@Table(name ="TRABAJOS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Trabajos {
	@Id
	@Column(name = "ID_TRABAJO")
	private Integer idTrabajo;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "SALARIO")
	private Float salario;
	
	//Un trabajo tiene muchos empleados 
	@OneToMany(mappedBy = "trabajos",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Empleados> listaEmpleados = new ArrayList<>();

	
}
