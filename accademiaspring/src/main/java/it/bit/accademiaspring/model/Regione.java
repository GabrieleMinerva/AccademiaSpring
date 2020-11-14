package it.bit.accademiaspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="regioni")
public class Regione {

	@Id
	@Column
	private int id;
	
	@Column
	private String nome;
	
	public Regione() {}
	public Regione(int i , String name) {
		id = i;
		nome = name;
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
}
