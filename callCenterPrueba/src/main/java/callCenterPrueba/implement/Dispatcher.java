package callCenterPrueba.implement;

import java.util.Vector;

import callCenterPrueba.dto.TiempoLlamadaDTO;
import callCenterPrueba.interfaz.DispatcherInterface;
import callCenterPrueba.service.Tiempos;

public class Dispatcher implements DispatcherInterface {

	public void duracionLlamada(int cantidadLlamadas){
		Tiempos tiempos = new Tiempos();
		Vector tiemposLlamadas = new Vector();
		TiempoLlamadaDTO tiemposLlamadasDto;
		for(int i = 1; i <= cantidadLlamadas ; i++){
			tiemposLlamadasDto = new TiempoLlamadaDTO();
			tiemposLlamadasDto.setCodigoLlamada(i);
			tiemposLlamadasDto.setDuraciónLlamada(tiempos.tiempoLlamada());
			tiemposLlamadas.add(tiemposLlamadasDto);
		}
	}
	
	public void dispatcherCall() {
		// TODO Auto-generated method stub
		
	}
	
	

}
