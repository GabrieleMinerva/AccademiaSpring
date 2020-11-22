package it.bit.accademiaspring.dto;

import it.bit.accademiaspring.model.Aula;
import it.bit.accademiaspring.model.Lezione;

public class LezioneDTO {

    private String data, orarioAula;


    public LezioneDTO(Lezione l) {
        this.data = l.getData();
        switch(l.getOrario().toString()) {
            case "MATTINA1": this.orarioAula = "9-11";
            break;
            case "MATTINA2": this.orarioAula = "11-13";
                break;
            case "POMERIGGIO1": this.orarioAula = "14-16";
                break;
            case "POMERIGGIO2": this.orarioAula = "16-18";
                break;

        }
        this.orarioAula = "Orario: " + this.orarioAula +" nell'Aula " + "'" +l.getAula().getNome() + "'" ;

    }

    public LezioneDTO() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOrarioAula() {
        return orarioAula;
    }

    public void setOrarioAula(String orarioAula) {
        this.orarioAula = orarioAula;
    }
}