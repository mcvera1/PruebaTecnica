package callCenterPrueba.service;

public class LlamadasEspera{

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
