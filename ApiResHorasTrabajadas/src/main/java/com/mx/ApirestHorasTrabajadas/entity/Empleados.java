package com.mx.ApirestHorasTrabajadas.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*CREATE TABLE EMPLEADOS_(
    ID_EMPLEADO NUMBER PRIMARY KEY NOT NULL,
    FK_GENERO NUMBER NOT NULL,
    FK_TRABAJO NUMBER NOT NULL,
    NOMBRE VARCHAR2(255)NOT NULL,
    APELLIDO_PATERNO VARCHAR2(255)NOT NULL,
    FECHA_NACIMINETO DATE NOT NULL,
    FOREIGN KEY(FK_GENERO) REFERENCES GENERO(ID_GENERO),
    FOREIGN KEY(FK_TRABAJO) REFERENCES TRABAJOS(ID_TRABAJO)
);
*/

@Entity
@Table(name = "EMPLEADOS_")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Empleados {
	@Id
	@Column(name = "ID_EMPLEADO")
	private Integer idEmpleado;
	
	//Muchos empleados tienen un genero 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_GENERO")
	Genero genero;
	
	//Muchos empleados tiene un trabajo
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_TRABAJO")
	Trabajos trabajos;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDO_PATERNO")
	private String apellidoPaterno;
	
	@Column (name = "FECHA_NACIMINETO")
	private LocalDate fechaNacimineto;
	
	//Un empleados tiene muchas horas trabajas
	@OneToMany(mappedBy = "empleados",cascade = CascadeType.ALL)
	@JsonIgnore
	List<EmpleadoHorasTrabajadas> listaHorasTrabajadas =  new ArrayList<>();
	
}


























