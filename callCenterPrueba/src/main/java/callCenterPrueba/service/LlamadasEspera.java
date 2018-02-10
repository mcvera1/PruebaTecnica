package callCenterPrueba.service;

public class LlamadasEspera{

		/**
		 * esperarXsegundos
		 * @param segundos
		 * metodo para las llamadas que quedan en espera
		 * le da un total de 15 segundos para pasar la 
		 * llamada a que sea asignada a alguien del 
		 * personal
		 */
		public void esperarXsegundos(int segundos) {
			try {
				
				while(segundos < 15){
					segundos++;
					Thread.sleep(1000);
					System.err.println("Espere".concat(String.valueOf(segundos)).concat("seg para ser atendido"));
				}
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
}
