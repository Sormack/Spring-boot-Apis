package com.mx.ApiRestAgencia.entity;

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

/*CREATE TABLE MARCAS(
    ID NUMBER PRIMARY KEY,
    NOMBRE VARCHAR2(100)NOT NULL,
    ORIGEN VARCHAR(80)NOT NULL,
    NUM_MODELO INT NOT NULL
);*/
@Entity
@Table(name = "MARCAS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Marcas {
	@Id
	@Column(name = "ID")
	private Integer idMarca;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ORIGEN")
	private String origen;
	
	@Column(name = "NUM_MODELO")
	private Integer numModelo;
	
	//Cardinalidad Una marca tiene muchos modelos
	@OneToMany(mappedBy = "marca",cascade = CascadeType.ALL)
	@JsonIgnore//Para omitir una propiedad o lista de propiedades 
	List<Modelos> lista = new ArrayList<>();
	//La variable lista no se agrega 
	
	
	
	
}




















