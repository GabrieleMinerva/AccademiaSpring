package it.bit.accademiaspring.dto;

public class DataIscrizioniDTO {
	private int idStudente;
	private int idCorso;
	
	public DataIscrizioniDTO(int idStudente, int idCorso) {
		this.idStudente = idStudente;
		this.idCorso = idCorso;
	}
	public int getIdStudente() {
		return idStudente;
	}
	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idIscrizione) {
		this.idCorso = idIscrizione;
	}
	
}
