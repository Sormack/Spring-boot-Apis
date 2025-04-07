package com.mx.ApirestHorasTrabajadas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApirestHorasTrabajadas.entity.Empleados;
import com.mx.ApirestHorasTrabajadas.service.EmpleadosServImp;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(path = "empleados")
@CrossOrigin
public class EmpleadosWebServ {
	
	@Autowired
	EmpleadosServImp empleadosServImp;
	
	@GetMapping(path = "listaEmpleados")
	public List<Empleados> listaEmpleados(){
		return empleadosServImp.mostrarEmpleados();
	}
	
	@PostMapping(path = "guardar")
	public ResponseEntity<?> gurdarEmpleado(@RequestBody Empleados empleado){
		String response = empleadosServImp.guardarNuevoEmpleado(empleado);
		if(response == "elIDExiste") {
			return new ResponseEntity<>("Ya existe el ID",HttpStatus.OK);
		}else if(response == "NombreExiste") {
			return new ResponseEntity<>("Ya existe un nombre igual registraado",HttpStatus.OK);
		}else if(response == "ApellidoExiste") {
			return new ResponseEntity<>("Ya existe un apellido Igual",HttpStatus.OK);
		}else if(response == "GeneroNoRegistrado"){
			return new ResponseEntity<>("Ese genero no a sido registrado",HttpStatus.OK);
		}else if(response == "MenorEdad") {
			return new ResponseEntity<>("El empleado es menor de edad",HttpStatus.OK);
		}else if(response == "TrabajoNoRegistrado") {
			return new ResponseEntity<>("El trabajo no a sido registrado",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Empleado Registrado",HttpStatus.OK);
		}
		
	}
	
	@PostMapping(path = "buscar")
	public Empleados buscarEmpleado(@RequestBody Empleados empleado) {
		return empleadosServImp.buscar(empleado.getIdEmpleado());
	}
	
	@PostMapping(path = "Editar")
	public void editarEmpleado(@RequestBody Empleados empleado) {	
		empleadosServImp.editarEmpleado(empleado);
	}
	
	@PostMapping(path= "elimianr")
	public void eliminarEmpleado(@RequestBody Empleados empleado) {
		empleadosServImp.eliminarEmpleado(empleado.getIdEmpleado());
	}
	
}



















