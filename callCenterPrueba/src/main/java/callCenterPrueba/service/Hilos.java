package callCenterPrueba.service;

import callCenterPrueba.dto.EmpleadoDTO;

public class Hilos implements Runnable {
	EmpleadoDTO empleadoDto;
	private boolean ocupado;

	public Hilos(EmpleadoDTO empleadoDto) {
		this.empleadoDto = empleadoDto;
	}

	/**
	 * run
	 * metodo encargado de asignar cada llamada un hilo 
	 * y validar cuanto demora 
	 */
	public void run() {
		System.out.println("Llamada:" + empleadoDto.getTiempoLlamadaDTO().getCodigoLlamada() + " atendida por:"
				+ Thread.currentThread().getName());
		esperarXsegundos(empleadoDto.getTiempoLlamadaDTO().getDuraciónLlamada());
		System.out.println(
				"Terminando llamada:".concat(String.valueOf(empleadoDto.getTiempoLlamadaDTO().getCodigoLlamada()).concat(" Duración")
						.concat(String.valueOf(empleadoDto.getTiempoLlamadaDTO().getDuraciónLlamada()).concat("seg"))
						.concat(" ").concat(Thread.currentThread().getName()).concat(empleadoDto.getRol())));
	}

	/**
	 * esperarXsegundos
	 * @param segundos
	 * se le pasan los segundos para determinar cuando 
	 * va a parar el hilo
	 */
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

	public EmpleadoDTO getEmpleadoDto() {
		return empleadoDto;
	}

	public void setEmpleadoDto(EmpleadoDTO empleadoDto) {
		this.empleadoDto = empleadoDto;
	}

}
