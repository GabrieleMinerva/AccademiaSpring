package it.bit.accademiaspring.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import it.bit.accademiaspring.model.Course;
import it.bit.accademiaspring.model.Iscrizione;
import it.bit.accademiaspring.model.Student;

public class IscrizioneDTO {

	private int id;
	private Integer valutazioneStudente;
	private Integer valutazioneCorso;	
	private int idCorso;
	private String titoloCorso;
	private int idStudente;
	private String nomeStudente;
	private String cognomeStudente;
	
	public IscrizioneDTO(Iscrizione iscrizione) {
		id = iscrizione.getId();
		valutazioneStudente = iscrizione.getValutazioneStudente();
		valutazioneCorso = iscrizione.getValutazioneCorso();
		idCorso = iscrizione.getCorso().getId();
		titoloCorso = iscrizione.getCorso().getNomeCorso();
		idStudente = iscrizione.getStudente().getId();
		nomeStudente = iscrizione.getStudente().getNome();
		cognomeStudente = iscrizione.getStudente().getCognome();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getValutazioneStudente() {
		return valutazioneStudente;
	}

	public void setValutazioneStudente(Integer valutazioneStudente) {
		this.valutazioneStudente = valutazioneStudente;
	}

	public Integer getValutazioneCorso() {
		return valutazioneCorso;
	}

	public void setValutazioneCorso(Integer valutazioneCorso) {
		this.valutazioneCorso = valutazioneCorso;
	}

	public int getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public String getTitoloCorso() {
		return titoloCorso;
	}

	public void setTitoloCorso(String titoloCorso) {
		this.titoloCorso = titoloCorso;
	}

	public int getIdStudente() {
		return idStudente;
	}

	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}

	public String getNomeStudente() {
		return nomeStudente;
	}

	public void setNomeStudente(String nomeStudente) {
		this.nomeStudente = nomeStudente;
	}

	public String getCognomeStudente() {
		return cognomeStudente;
	}

	public void setCognomeStudente(String cognomeStudente) {
		this.cognomeStudente = cognomeStudente;
	}
}
