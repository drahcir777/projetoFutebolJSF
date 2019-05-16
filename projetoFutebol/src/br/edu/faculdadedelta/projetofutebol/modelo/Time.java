package br.edu.faculdadedelta.projetofutebol.modelo;

public class Time {
	
	private Long idTime;
	private String nomeTime;
	public Time() {
		super();
	}
	public Time(Long idTime, String nomeTime) {
		super();
		this.idTime = idTime;
		this.nomeTime = nomeTime;
	}
	public Long getIdTime() {
		return idTime;
	}
	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}
	public String getNomeTime() {
		return nomeTime;
	}
	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTime == null) ? 0 : idTime.hashCode());
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
		Time other = (Time) obj;
		if (idTime == null) {
			if (other.idTime != null)
				return false;
		} else if (!idTime.equals(other.idTime))
			return false;
		return true;
	}
	
}
