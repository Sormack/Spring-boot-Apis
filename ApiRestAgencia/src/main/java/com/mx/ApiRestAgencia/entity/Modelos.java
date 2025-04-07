package com.mx.ApiRestAgencia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*CREATE TABLE MODELOS(
    ID NUMBER PRIMARY KEY,
    NOMBRE VARCHAR2(100)NOT  NULL,
    PLACA VARCHAR2(20)NOT NULL,
    PRECIO NUMBER NOT NULL,
    FK_MARCA NUMBER NOT NULL,
    FOREIGN KEY(FK_MARCA) REFERENCES MARCAS(ID)
)*/

@Entity
@Table(name = "MODELOS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Modelos {
	@Id
	@Column(name = "ID")
	private Integer idModelo;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name= "PLACA")
	private String placa;
	
	@Column(name = "PRECIO")
	private Float precio;
	
	//Cardinalidad -- muchos modelos tienen marca 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_MARCA")
	Marcas marca;//Esta variable de tipo objeto debe ser igual a lo que esta en mappedBy
	
	
}




























