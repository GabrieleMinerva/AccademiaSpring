package it.bit.accademiaspring.dto;

import it.bit.accademiaspring.model.Azienda;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AziendaDTO {

    private int id;
    private String nome;
    private String descrizione;
    private String contatto;
    private String citta;
    private String via;
    private String cap;

    public AziendaDTO() {
    }

    public AziendaDTO(Azienda azienda) {
        this.id = azienda.getId();
        this.nome = azienda.getNome();
        this.descrizione = azienda.getDescrizione();
        this.contatto = azienda.getContatto();
        this.citta = azienda.getCitta();
        this.via = azienda.getVia();
        this.cap = azienda.getCap();
    }

    public AziendaDTO(int id, String nome, String descrizione, String contatto, String citta, String via, String cap) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.contatto = contatto;
        this.citta = citta;
        this.via = via;
        this.cap = cap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getContatto() {
        return contatto;
    }

    public void setContatto(String contatto) {
        this.contatto = contatto;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }
}
