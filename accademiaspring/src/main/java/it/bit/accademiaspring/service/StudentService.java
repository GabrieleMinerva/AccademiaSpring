package it.bit.accademiaspring.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import it.bit.accademiaspring.dto.DataIscrizioniDTO;
import it.bit.accademiaspring.model.Iscrizione;
import it.bit.accademiaspring.model.Student;

public interface StudentService {

	public Collection<Student> findAll();
	
	public Optional<Student> findById(int theId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);
	
	public void patch(Student theStudent);
	
	public int creaIscrizione(DataIscrizioniDTO dataIsc);
	
	public void deleteIscrizione(int theId);
	
	public Optional<Iscrizione> findIscrizione(int theId);
	
	public Student findByNomeAndCognome(String nome, String cognome);
	
	public List<Student> findByNomeLikeAndCognomeLike(String nome, String cognome);
}
