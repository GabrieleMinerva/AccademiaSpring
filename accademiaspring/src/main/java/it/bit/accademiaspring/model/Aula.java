package it.bit.accademiaspring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="aula")
public class Aula {
	@Id
	private int id;
	private String nome;
	private String capienza;
	private String virtuale;
	@Column(name="id_software")
	private Integer idSoftware;
	@OneToMany(mappedBy="aula",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Lezione> lezioni;
	
	public Aula() {}
	
	public Aula(int id, String nome, String capienza, String virtuale, Integer idSoftware) {
		this.id = id;
		this.nome = nome;
		this.capienza = capienza;
		this.virtuale = virtuale;
		this.idSoftware = idSoftware;
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
	public String getCapienza() {
		return capienza;
	}
	public void setCapienza(String capienza) {
		this.capienza = capienza;
	}
	public String getVirtuale() {
		return virtuale;
	}
	public void setVirtuale(String virtuale) {
		this.virtuale = virtuale;
	}
	public Integer getIdSoftware() {
		return idSoftware;
	}
	public void setIdSoftware(Integer idSoftware) {
		this.idSoftware = idSoftware;
	}
	
}
