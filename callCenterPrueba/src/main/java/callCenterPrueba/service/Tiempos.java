package callCenterPrueba.service;

public class Tiempos {
	
	/**
	 *metodo encargado de asignar el tiempo aleatorio 
	 *a la llamada entre 5 y 10 seg 
	 * @return
	 */
	public int tiempoLlamada(){
	    int Max=10+1;// cota sup mas 1
        int Min=5;
        int tiempoLlamada = 0;
        tiempoLlamada = ((int)(Math.random()*(Max-Min))+Min);
        return tiempoLlamada;
	}
}
