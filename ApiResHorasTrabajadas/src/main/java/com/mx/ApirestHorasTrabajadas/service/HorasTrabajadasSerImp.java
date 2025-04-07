package com.mx.ApirestHorasTrabajadas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApirestHorasTrabajadas.entity.EmpleadoHorasTrabajadas;
import com.mx.ApirestHorasTrabajadas.entity.Empleados;
import com.mx.ApirestHorasTrabajadas.repository.EmpleadoHorasTrabajadasRepository;
import com.mx.ApirestHorasTrabajadas.repository.EmpleadosRepository;

@Service
public class HorasTrabajadasSerImp {

	@Autowired
	EmpleadoHorasTrabajadasRepository empleadoHorasTrabajadasRepository;
	@Autowired
	EmpleadosRepository empleadosRepository;
	//Listar las horas trabajadas
	
	@Transactional(readOnly = true)
	public List<EmpleadoHorasTrabajadas> listar(){
		return empleadoHorasTrabajadasRepository.findAll();
	}
	
	//Guardar Horas trabajadas
	public String guardarHorasTrabajadas(EmpleadoHorasTrabajadas horasTrabajadas) {
		String mensaje = "guardado";
		
		if(!empleadosRepository.existsById(horasTrabajadas.getEmpleados().getIdEmpleado())) {
			return mensaje = "noRegistrado";
		}else {
			empleadoHorasTrabajadasRepository.save(horasTrabajadas);
		}
		return mensaje; 
	}
	
	//buscar
		@Transactional(readOnly = true)
		public EmpleadoHorasTrabajadas buscar(Integer idHorasTrabajadas) {
			return empleadoHorasTrabajadasRepository.findById(idHorasTrabajadas).orElse(null);
		}
		
		//Editar
		@Transactional
		public void editarHorasTrabajadas(EmpleadoHorasTrabajadas horasTrabajadas) {
			empleadoHorasTrabajadasRepository.save(horasTrabajadas);
		}
		
		//Eliminar
		public void eliminarHorasTrabajadas(Integer idHorasTrabajadas) {
			empleadoHorasTrabajadasRepository.deleteById(idHorasTrabajadas);
		}
	
	
}
