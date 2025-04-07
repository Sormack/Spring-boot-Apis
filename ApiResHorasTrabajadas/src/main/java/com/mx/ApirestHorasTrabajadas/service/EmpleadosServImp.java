package com.mx.ApirestHorasTrabajadas.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApirestHorasTrabajadas.entity.Empleados;
import com.mx.ApirestHorasTrabajadas.entity.Genero;
import com.mx.ApirestHorasTrabajadas.entity.Trabajos;
import com.mx.ApirestHorasTrabajadas.repository.EmpleadosRepository;
import com.mx.ApirestHorasTrabajadas.repository.GeneroRepository;
import com.mx.ApirestHorasTrabajadas.repository.TrabajosRepository;

@Service
public class EmpleadosServImp {
	@Autowired
	EmpleadosRepository empleadosRepository;
	@Autowired
	GeneroRepository generoRepository;
	@Autowired
	TrabajosRepository trabajosRepository;

	// mostrar empleados
	@Transactional(readOnly = true)
	public List<Empleados> mostrarEmpleados() {
		return empleadosRepository.findAll();
	}

	// Guardar nuevo empleado
	@Transactional
	public String guardarNuevoEmpleado(Empleados empleado) {
		String respuesta = "guardado";
		boolean bandera = false;
		for (Empleados e : empleadosRepository.findAll()) {
			if (e.getNombre().equals(empleado.getNombre())) {
				bandera = true;
				return respuesta = "NombreExiste";
			}else if(e.getApellidoPaterno().equals(empleado.getApellidoPaterno())){
				bandera = true;
				return respuesta = "ApellidoExiste";
			}
		}
		
		if ((Period.between(empleado.getFechaNacimineto(), LocalDate.now())).getYears() <18) {
			bandera  = true;
			return respuesta = "MenorEdad";
		}else if(!generoRepository.existsById(empleado.getGenero().getIdGenero())) {
			bandera = true;
			return respuesta = "GeneroNoRegistrado";
		}else if(!trabajosRepository.existsById(empleado.getTrabajos().getIdTrabajo())) {
			bandera = true;
			return respuesta = "TrabajoNoRegistrado";
		}
		
		
		if (bandera == false) {
			empleadosRepository.save(empleado);
		}
		return respuesta;
	}
	
	//buscar
	@Transactional(readOnly = true)
	public Empleados buscar(Integer idEmpleado) {
		return empleadosRepository.findById(idEmpleado).orElse(null);
	}
	
	//Editar
	@Transactional
	public void editarEmpleado(Empleados empleado) {
		empleadosRepository.save(empleado);
	}
	
	//Eliminar
	public void eliminarEmpleado(Integer idEmpleado) {
		empleadosRepository.deleteById(idEmpleado);
	}
	
	
}








