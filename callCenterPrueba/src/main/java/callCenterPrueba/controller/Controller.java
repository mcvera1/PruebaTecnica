package callCenterPrueba.controller;

import callCenterPrueba.implement.Dispatcher;
import callCenterPrueba.interfaz.DispatcherInterface;
/**
 * 
 * @author vera
 *metodo encargado para llamar cada uno de 
 *los metodos que asignan las llamadas
 */
public class Controller {
	
	public static void main(String arg[]){
		DispatcherInterface dispatcher = new Dispatcher();
		final int cantidadEmpleados=5;
		final int cantidadLlamadas = 7;
		dispatcher.duracionLlamada(cantidadLlamadas);
		dispatcher.cantidadEmpleado(cantidadEmpleados);
		dispatcher.dispatcherCall();
		dispatcher.llamadasEspera();
		dispatcher.cantidadAsesoresDisponibles();
	}
}
