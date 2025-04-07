package com.mx.ApirestHorasTrabajadas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApirestHorasTrabajadas.entity.EmpleadoHorasTrabajadas;
import com.mx.ApirestHorasTrabajadas.entity.Empleados;
import com.mx.ApirestHorasTrabajadas.service.HorasTrabajadasSerImp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping(path = "horasTrabajadas")
@CrossOrigin
public class HorasTrabajadasWebServ {

	@Autowired
	HorasTrabajadasSerImp horasTrabajadasSerImp;
	@GetMapping(path = "mostrar")
	public List<EmpleadoHorasTrabajadas> mostrar() {
		return horasTrabajadasSerImp.listar();
	}
	
	
	@PostMapping(path = "Guardar")
	public ResponseEntity<?> guardar(@RequestBody EmpleadoHorasTrabajadas empleadoHorasTrabajadas) {
		String response  = horasTrabajadasSerImp.guardarHorasTrabajadas(empleadoHorasTrabajadas);
		if(response == "noRegistrado") {
			return new ResponseEntity<>("Horas no registradas",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Horas registradas",HttpStatus.OK);
		}
	}
	
	@PostMapping(path = "buscar")
	public EmpleadoHorasTrabajadas mostarEmpleado(@RequestBody EmpleadoHorasTrabajadas empleadoHorasTrabajadas) {
		return horasTrabajadasSerImp.buscar(empleadoHorasTrabajadas.getIdHorasTrabajadas());
	}
	
	@PostMapping(path = "editar")
	public void editarHorasTrabajadas(@RequestBody EmpleadoHorasTrabajadas empleadoHorasTrabajadas) {
		horasTrabajadasSerImp.editarHorasTrabajadas(empleadoHorasTrabajadas);
	}
	
	@PostMapping(path = "eliminar")
	public void elimianarHorasTrabajadas(@RequestBody EmpleadoHorasTrabajadas empleadoHorasTrabajadas) {
		horasTrabajadasSerImp.eliminarHorasTrabajadas(empleadoHorasTrabajadas.getIdHorasTrabajadas());
	}
	
	
	
	
	
}
