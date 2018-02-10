package callCenterPrueba.implement;

import java.util.Vector;

import callCenterPrueba.dto.EmpleadoDTO;
import callCenterPrueba.dto.TiempoLlamadaDTO;
import callCenterPrueba.interfaz.DispatcherInterface;
import callCenterPrueba.service.EstadoEmpleados;
import callCenterPrueba.service.Hilos;
import callCenterPrueba.service.LlamadasEspera;
import callCenterPrueba.service.Tiempos;

public class Dispatcher implements DispatcherInterface {
	Vector totalEmpleados = new Vector();
	Vector tiemposLlamadas = new Vector();
	Vector tiemposLlamadasEspera = new Vector();
	EstadoEmpleados estadoEmpleado = new EstadoEmpleados();
	final String operador = "operador";
	final String supervisor = "supervisor";
	final String director = "director";
	
	/**
	 * duracionLlamada
	 * @param cantidadLlamadas
	 * le asigna un codigo a cada llamada para hacerle seguimiento
	 * ademas simula la cantidad de segundos que se va a demorar
	 * cada llamada que es de 5 a 10 segundos como maximo
	 * y valida si la cantidad de llamadas es mayor
	 * a 10 las llamadas siguientes las amacena en un arreglo para
	 * atenderlas despues de las primeras 10 llamadas
	 */
	public void duracionLlamada(int cantidadLlamadas){
		Tiempos tiempos = new Tiempos();
		TiempoLlamadaDTO tiemposLlamadasDto;
		
		for(int i = 1; i <= cantidadLlamadas ; i++){
			tiemposLlamadasDto = new TiempoLlamadaDTO();
			tiemposLlamadasDto.setCodigoLlamada(i);
			tiemposLlamadasDto.setDuraciónLlamada(tiempos.tiempoLlamada());
			tiemposLlamadasDto.setLlamadaAtendida(false);
			if(i<=10){
				tiemposLlamadas.add(tiemposLlamadasDto);				
			}else if(i>10){
				tiemposLlamadasEspera.addElement(tiemposLlamadasDto);
			}
			
		}
	}
	
	
	/**cantidadEmpleado
	 * cantidadEmpleado
	 * @param cantidadEmpleados
	 * valida la cantidad de empleados para el callcenter
	 * por defecto se asignaron 10 empleados 5 operadores,
	 * 3 supervisores y 2 directores para validar si se da
	 * el caso de que lleguen 10 llamadas al mismo tiempo
	 */
	public void cantidadEmpleado(int cantidadEmpleados){
		EmpleadoDTO empleadoDto;
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
	
	/**dispatcherCall
	 * realiza la direccion de llamadas entre los empleados
	 * que esten disponibles a cada llamada se le asigna un hilo
	 * que es el encargado de determinar cuanto se demora cada
	 * llamada atendida por el personal
	 */
	public void dispatcherCall() {
		
		for(int i = 0; i < totalEmpleados.size(); i++){
			EmpleadoDTO atiendeLlamada = (EmpleadoDTO)totalEmpleados.get(i);
			int j = 0;
			if(j<tiemposLlamadas.size()){
				TiempoLlamadaDTO tiempo = (TiempoLlamadaDTO)tiemposLlamadas.get(j);
				if(!atiendeLlamada.isEstado()){
					if(!tiempo.isLlamadaAtendida()){
						tiempo.setLlamadaAtendida(true);
						atiendeLlamada.setEstado(true);
						atiendeLlamada.setTiempoLlamadaDTO(tiempo);
						
						//parte de los hilos
						Hilos hilo = new Hilos(atiendeLlamada);
						Thread hilos = new Thread(hilo);
						hilos.setName(atiendeLlamada.getDescripcion());
						hilos.start();
						//fin hilos	
						
						tiemposLlamadas.remove(j);
					}
					j++;
				}	
			}
		}
	}
	
	/**
	 * llamadasEspera
	 * valida si hay alguna llamada en espera aparte de las 10 que 
	 * entraron y una vez terminen de atender las 10 primeras llamadas 
	 * asigna la llamada a uno de los empleados se valida si el arreglo
	 * que se creo para las llamadas en espera tiene registros se crea un 
	 * hilo por 15 seg para que termine las primeras 10 llamadas una vez
	 * hecho esto le asigna al arreglo de las llamadas principales las
	 * llamadas faltantes y llama de nuevo el dispatcher para asignar
	 * estàs llamadas
	 */
	public void llamadasEspera(){
		LlamadasEspera llamadasEspera = new LlamadasEspera();
		if(tiemposLlamadasEspera.size() > 0){
			llamadasEspera.esperarXsegundos(0);
			tiemposLlamadas = tiemposLlamadasEspera;
			asesores();
			dispatcherCall();			
		}
	}
	
	/**
	 * asesores
	 * le agrega un estado al asesor aleatorio
	 * para saber si el empleado esta ocupado o
	 * puede atender la llamada
	 * true = ocupado
	 * false = libre(puede atender llamada)
	 */
	private void asesores(){
		for(int i = 0; i < totalEmpleados.size(); i++){
			EmpleadoDTO atiendeLlamada = (EmpleadoDTO)totalEmpleados.get(i);
			atiendeLlamada.setEstado(estadoEmpleado.getBoolean());
		}
	}
	
	/**
	 * cantidadAsesoresDisponibles
	 * metodo que se encarga de validar cuando llega una llamada
	 * y los asesores estàn ocupados primero e valida en el metodo
	 * dispatchercall que las llamadas hayan sido atendidas asignandoles
	 * el valor de true una vez se haya asignado las llamadas a los empleados
	 * de ese momento se valida cuantos llamadas quedan en espera se devuelve
	 * el estado de los asesores a libre para que puedan atender las llamadas
	 * y se llama de nuevo la clase dispatcher pero primero se ejecuta un hilo
	 * por 15 seg para esperar a que terminen las llamadas anteriores
	 */
	public void cantidadAsesoresDisponibles(){
		LlamadasEspera llamadasEspera = new LlamadasEspera();
		for(int i = 0; i < totalEmpleados.size(); i++){
			EmpleadoDTO atiendeLlamada = (EmpleadoDTO)totalEmpleados.get(i);
			atiendeLlamada.setEstado(false);
		}
		if(tiemposLlamadas.size() > 0){
			llamadasEspera.esperarXsegundos(0);
			dispatcherCall();
		}
	}


	public Vector getTiemposLlamadas() {
		return tiemposLlamadas;
	}
	
	
	
}
