package callCenterPrueba.service;

public class LlamadasEspera implements Runnable{

		private void esperarXsegundos(int segundos) {
			try {
				Thread.sleep(segundos * 1000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

		public void run() {
			esperarXsegundos(2);
			System.out.println(
					"espere 20 segundos para ser atendido");
			
		}
}
