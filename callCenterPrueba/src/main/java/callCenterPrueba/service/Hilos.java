package callCenterPrueba.service;

import callCenterPrueba.dto.EmpleadoDTO;

public class Hilos implements Runnable {
	EmpleadoDTO empleadoDto;
	
	public Hilos(EmpleadoDTO empleadoDto){
		this.empleadoDto = empleadoDto;
	}
	
	public void run() {
		System.out.println("Llamando al método run de HiloNuevo...");

		System.out.println(empleadoDto.getRol()+" "+ Thread.currentThread().getName());
		esperarXsegundos(empleadoDto.getTiempoLlamadaDTO().getDuraciónLlamada());
		System.out.println("Terminando el trabajo..."+" "+Thread.currentThread().getName());
	}
	
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
		

}
