package it.bit.accademiaspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import it.bit.accademiaspring.enu.Orario;

@Entity
@Table(name="lezioni")
public class Lezione {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Orario orario;
	
	@Column
	private String data;
	
	@ManyToOne
	@JoinColumn(name="id_aula")
	private Aula aula;
	
	@ManyToOne
	@JoinColumn(name="id_corso")
	private Course corso;
	
	public Lezione() {}

	public Lezione(Orario orario, String data, Aula aula, Course corso) {
		this.orario = orario;
		this.data = data;
		this.aula = aula;
		this.corso = corso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orario getOrario() {
		return orario;
	}

	public void setOrario(Orario orario) {
		this.orario = orario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Course getCorso() {
		return corso;
	}

	public void setCorso(Course corso) {
		this.corso = corso;
	}	
}
