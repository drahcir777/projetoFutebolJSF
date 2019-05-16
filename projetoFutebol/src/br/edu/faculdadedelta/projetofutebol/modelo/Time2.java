package br.edu.faculdadedelta.projetofutebol.modelo;

public class Time2 {
	
	private Long idTime2;
	private String nomeTime2;
	public Time2() {
		super();
	}
	public Time2(Long idTime2, String nomeTime2) {
		super();
		this.idTime2 = idTime2;
		this.nomeTime2 = nomeTime2;
	}
	public Long getIdTime2() {
		return idTime2;
	}
	public void setIdTime2(Long idTime2) {
		this.idTime2 = idTime2;
	}
	public String getNomeTime2() {
		return nomeTime2;
	}
	public void setNomeTime2(String nomeTime2) {
		this.nomeTime2 = nomeTime2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTime2 == null) ? 0 : idTime2.hashCode());
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
		Time2 other = (Time2) obj;
		if (idTime2 == null) {
			if (other.idTime2 != null)
				return false;
		} else if (!idTime2.equals(other.idTime2))
			return false;
		return true;
	}
	
	
}
