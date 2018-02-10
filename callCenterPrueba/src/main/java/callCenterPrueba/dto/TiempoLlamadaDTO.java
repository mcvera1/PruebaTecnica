package callCenterPrueba.dto;

public class TiempoLlamadaDTO {
	private int codigoLlamada;
	private int duraciónLlamada;
	private boolean llamadaAtendida;
	public int getCodigoLlamada() {
		return codigoLlamada;
	}
	public void setCodigoLlamada(int codigoLlamada) {
		this.codigoLlamada = codigoLlamada;
	}
	public int getDuraciónLlamada() {
		return duraciónLlamada;
	}
	public void setDuraciónLlamada(int duraciónLlamada) {
		this.duraciónLlamada = duraciónLlamada;
	}
	public boolean isLlamadaAtendida() {
		return llamadaAtendida;
	}
	public void setLlamadaAtendida(boolean llamadaAtendida) {
		this.llamadaAtendida = llamadaAtendida;
	}
	
	
}
