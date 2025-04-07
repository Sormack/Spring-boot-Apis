package com.mx.ApirestHorasTrabajadas.entity;

import java.sql.Date;

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

/*CREATE TABLE EMPLEADO_HORAS_TRABAJADAS(
    ID_EMPLEADO_HORAS_TRABAJADAS NUMBER PRIMARY KEY NOT NULL,
    FK_EMPLEADO NUMBER NOT NULL,
    HORAS_TRABAJADAS NUMBER NOT NULL,
    FECHA_TRABAJO DATE NOT NULL,
    FOREIGN KEY(FK_EMPLEADO) REFERENCES EMPLEADOS_(ID_EMPLEADO) 
)*/

@Entity
@Table(name = "EMPLEADO_HORAS_TRABAJADAS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpleadoHorasTrabajadas {
	@Id
	@Column(name = "ID_EMPLEADO_HORAS_TRABAJADAS")
	private Integer idHorasTrabajadas;
	
	//Muchas horas trabajadas tiene un empleado 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_EMPLEADO")
	Empleados empleados;
	
	@Column(name = "HORAS_TRABAJADAS")
	private Integer horasTrabajadas;
	
	@Column(name = "FECHA_TRABAJO")
	private Date fechaTrabajo;
	
	
	
}




















