package br.edu.faculdadedelta.projetofutebol.modelo;

public class Partida {
	
	private Long idPartida;
	private Status status;
	private Time time;
	private Time2 time2;
	private int qtdGolTime;
	private int qtdGolTime2;
	private String localPartida;
	private String horario;
	public Partida() {
		super();
	}
	public Partida(Long idPartida, Status status, Time time, Time2 time2, int qtdGolTime, int qtdGolTime2,
			String localPartida, String horario) {
		super();
		this.idPartida = idPartida;
		this.status = status;
		this.time = time;
		this.time2 = time2;
		this.qtdGolTime = qtdGolTime;
		this.qtdGolTime2 = qtdGolTime2;
		this.localPartida = localPartida;
		this.horario = horario;
	}
	public Long getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(Long idPartida) {
		this.idPartida = idPartida;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Time2 getTime2() {
		return time2;
	}
	public void setTime2(Time2 time2) {
		this.time2 = time2;
	}
	public int getQtdGolTime() {
		return qtdGolTime;
	}
	public void setQtdGolTime(int qtdGolTime) {
		this.qtdGolTime = qtdGolTime;
	}
	public int getQtdGolTime2() {
		return qtdGolTime2;
	}
	public void setQtdGolTime2(int qtdGolTime2) {
		this.qtdGolTime2 = qtdGolTime2;
	}
	public String getLocalPartida() {
		return localPartida;
	}
	public void setLocalPartida(String localPartida) {
		this.localPartida = localPartida;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPartida == null) ? 0 : idPartida.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		if (idPartida == null) {
			if (other.idPartida != null)
				return false;
		} else if (!idPartida.equals(other.idPartida))
			return false;
		return true;
	}
	
}
