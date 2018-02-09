package callCenterPrueba.dto;

public class EmpleadoDTO {
	private String rol;
	private boolean estado;
	private TiempoLlamadaDTO tiempoLlamadaDTO;
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public TiempoLlamadaDTO getTiempoLlamadaDTO() {
		return tiempoLlamadaDTO;
	}
	public void setTiempoLlamadaDTO(TiempoLlamadaDTO tiempoLlamadaDTO) {
		this.tiempoLlamadaDTO = tiempoLlamadaDTO;
	}
}
