package callCenterPrueba.implement;

import java.util.Vector;

import callCenterPrueba.dto.EmpleadoDTO;
import callCenterPrueba.dto.TiempoLlamadaDTO;
import callCenterPrueba.interfaz.DispatcherInterface;
import callCenterPrueba.service.EstadoEmpleados;
import callCenterPrueba.service.Hilos;
import callCenterPrueba.service.Tiempos;

public class Dispatcher implements DispatcherInterface {
	Vector totalEmpleados = new Vector();
	Vector tiemposLlamadas = new Vector();
	final String operador = "operador";
	final String supervisor = "supervisor";
	final String director = "director";
	
	public void duracionLlamada(int cantidadLlamadas){
		Tiempos tiempos = new Tiempos();
		TiempoLlamadaDTO tiemposLlamadasDto;
		
		for(int i = 1; i <= cantidadLlamadas ; i++){
			tiemposLlamadasDto = new TiempoLlamadaDTO();
			tiemposLlamadasDto.setCodigoLlamada(i);
			tiemposLlamadasDto.setDuraciónLlamada(tiempos.tiempoLlamada());
			tiemposLlamadas.add(tiemposLlamadasDto);
		}
	}
	
	public void cantidadEmpleado(int cantidadEmpleados){
		EmpleadoDTO empleadoDto;
		EstadoEmpleados estadoEmpleado = new EstadoEmpleados();
		for(int i = 1; i <= cantidadEmpleados; i++ ){
			empleadoDto = new EmpleadoDTO();
			//empleadoDto.setEstado(estadoEmpleado.getBoolean());
			empleadoDto.setEstado(false);
			empleadoDto.setRol(String.valueOf(i));
			if(i <= 5){
				empleadoDto.setDescripcion(operador);
			}else if(i <= 8){
				empleadoDto.setDescripcion(supervisor);
			}else{
				empleadoDto.setDescripcion(director);
			}
			totalEmpleados.add(empleadoDto);
		}	
	}
	
	public void dispatcherCall() {
		int j = 0;
		for(int i = 0; i < totalEmpleados.size(); i++){
			EmpleadoDTO atiendeLlamada = (EmpleadoDTO)totalEmpleados.get(i);
			
			if(j<tiemposLlamadas.size()){
				TiempoLlamadaDTO tiempo = (TiempoLlamadaDTO)tiemposLlamadas.get(j);
				if(!atiendeLlamada.isEstado()){
					atiendeLlamada.setEstado(true);
					atiendeLlamada.setTiempoLlamadaDTO(tiempo);
					
					//parte de los hilos
					Hilos hilo = new Hilos(atiendeLlamada);
					Thread hilos = new Thread(hilo);
					hilos.setName(atiendeLlamada.getDescripcion());
					hilos.start();
					//fin hilos	
					
					j++;
				}
				
				
			}
		}
	}
	
}
