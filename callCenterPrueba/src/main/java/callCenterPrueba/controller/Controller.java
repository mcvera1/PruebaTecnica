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
		final int cantidadEmpleados=6;
		final int cantidadLlamadas = 10;
		dispatcher.duracionLlamada(cantidadLlamadas);
		dispatcher.cantidadEmpleado(cantidadEmpleados);
		dispatcher.dispatcherCall();
		dispatcher.llamadasEspera();
	}
}
