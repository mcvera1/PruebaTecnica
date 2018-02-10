package callCenterPrueba.callCenterPrueba;

import callCenterPrueba.implement.Dispatcher;

public class App {
    public static void main( String[] args ){
    	Dispatcher di = new Dispatcher();
    	di.duracionLlamada(11);
    	di.cantidadEmpleado(10);
    	di.dispatcherCall();// valida cuando llegan 10 llamadas
    	
    	di.llamadasEspera();
    }
}
