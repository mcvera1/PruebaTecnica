package callCenterPrueba.implement;

import java.util.Vector;

import callCenterPrueba.dto.EmpleadoDTO;
import callCenterPrueba.dto.TiempoLlamadaDTO;
import callCenterPrueba.interfaz.DispatcherInterface;
import callCenterPrueba.service.Hilos;
import callCenterPrueba.service.Tiempos;

public class Dispatcher implements DispatcherInterface {
	Vector totalEmpleados = new Vector();
	Vector tiemposLlamadas = new Vector();
	
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
		for(int i = 1; i <= cantidadEmpleados; i++ ){
			empleadoDto = new EmpleadoDTO();
			empleadoDto.setEstado(false);
			empleadoDto.setRol(String.valueOf(i));
			totalEmpleados.add(empleadoDto);
		}	
	}
	
	public void dispatcherCall() {
		int j = 0;
		for(int i = 0; i < totalEmpleados.size(); i++){
			EmpleadoDTO atiendeLlamada = (EmpleadoDTO)totalEmpleados.get(i);
			
			if(j<tiemposLlamadas.size()){
				TiempoLlamadaDTO tiempo = (TiempoLlamadaDTO)tiemposLlamadas.get(j);
				atiendeLlamada.setEstado(true);
				atiendeLlamada.setTiempoLlamadaDTO(tiempo);
				
				//parte de los hilos
				Hilos hilo = new Hilos(atiendeLlamada);
				Thread hilos = new Thread(hilo);
				hilos.setName(atiendeLlamada.getRol());
				hilos.start();
				//fin hilos
				
				j++;
			}
		}
			
		
	}
	
	

}
