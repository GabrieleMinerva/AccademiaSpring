package it.bit.accademiaspring.dto;

	import java.util.ArrayList;
	import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.bit.accademiaspring.model.Iscrizione;
import it.bit.accademiaspring.model.Regione;
import it.bit.accademiaspring.model.Student;

	public class StudentDTO {
		
		private int id; 
		
		private String fullName;
		
		private String dataDiNascita; 
		
		private String CF;
		
		private String email;
		
		private String telefono;
		
		private int idRegione;
		
		private String nomeRegione;
		
		
		private List<IscrizioneDTO> iscrizioni = new ArrayList<IscrizioneDTO>();
		public StudentDTO() {}
		public StudentDTO(Student s) {
			this.id = s.getId();
			this.fullName = s.getNome()+"_"+s.getCognome();
			this.dataDiNascita = s.getDataDiNascita();
			CF = s.getCF();
			this.email = s.getEmail();
			this.telefono = s.getTelefono();
			this.idRegione = s.getRegione().getId();
			this.nomeRegione = s.getRegione().getNome();
			this.iscrizioni = s.getIscrizioni().stream().map(IscrizioneDTO::new).collect(Collectors.toList());
		}

		public String getNomeRegione() {
			return nomeRegione;
		}
		public void setNomeRegione(String nomeRegione) {
			this.nomeRegione = nomeRegione;
		}
		public int getIdRegione() {
			return idRegione;
		}
		public void setIdRegione(int idRegione) {
			this.idRegione = idRegione;
		}
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getDataDiNascita() {
			return dataDiNascita;
		}

		public void setDataDiNascita(String dataDiNascita) {
			this.dataDiNascita = dataDiNascita;
		}

		public String getCF() {
			return CF;
		}

		public void setCF(String cF) {
			CF = cF;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public List<IscrizioneDTO> getIscrizioni() {
			return iscrizioni;
		}

		public void setIscrizioni(List<IscrizioneDTO> iscrizioni) {
			this.iscrizioni = iscrizioni;
		}

		public Student toStudent() {
			Student s = new Student(fullName.split("_")[0], fullName.split("_")[1]
					, dataDiNascita, CF, email, telefono, null, null, null, new Regione(idRegione,nomeRegione), null);
			if(this.id!=0){
				s.setId(this.id);
			}
			return s;
		}
		
}
