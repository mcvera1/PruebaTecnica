package callCenterPrueba.service;

import callCenterPrueba.dto.EmpleadoDTO;

public class Hilos implements Runnable {
	EmpleadoDTO empleadoDto;
	private boolean ocupado;
	
	public Hilos(EmpleadoDTO empleadoDto){
		this.empleadoDto = empleadoDto;
	}
	
	public void run() {
		//System.out.println("Llamando al método run de HiloNuevo...");
		System.out.println(empleadoDto.getRol());
		setOcupado(true);
		esperarXsegundos(empleadoDto.getTiempoLlamadaDTO().getDuraciónLlamada());
		System.out.println("Terminando el trabajo...".concat(" ").concat(Thread.currentThread().getName()));
		setOcupado(false);
	}
	
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

}
