package it.bit.accademiaspring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bit.accademiaspring.dto.DataIscrizioniDTO;
import it.bit.accademiaspring.model.Course;
import it.bit.accademiaspring.model.Iscrizione;
import it.bit.accademiaspring.model.Student;
import it.bit.accademiaspring.repo.CourseSpringRepo;
import it.bit.accademiaspring.repo.IscrizioniSpringRepo;
import it.bit.accademiaspring.repo.StudentSpringRepo;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentSpringRepo repo;
	private CourseSpringRepo cRepo;
	private IscrizioniSpringRepo iRepo;
	
	@Autowired
	public StudentServiceImpl(StudentSpringRepo theRepo, CourseSpringRepo theCRepo, IscrizioniSpringRepo theIRepo) {
		repo = theRepo;
		cRepo = theCRepo;
		iRepo = theIRepo;
	}
	
	
	@Override
	public Collection<Student> findAll() {
		return StreamSupport.stream(repo.findAll().spliterator(), false)
				    .collect(Collectors.toList());
	}

	@Override
	public Optional<Student> findById(int theId) {
		return repo.findById(theId);
	}

	@Override
	public void save(Student theStudent) {
		repo.save(theStudent);
		
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
		
	}


	@Override
	@Transactional
	public void patch(Student theStudent) {
		repo.patch(theStudent);
	}


	@Override
	@Transactional
	public int creaIscrizione(DataIscrizioniDTO dataIsc) {
		// da gestire le varie eccezioni
		Student s = repo.findById(dataIsc.getIdStudente()).get();
		Course c = cRepo.findById(dataIsc.getIdCorso()).get();
		Iscrizione isc = new Iscrizione(s,c);
		iRepo.save(isc);
		return isc.getId();
	}


	@Override
	@Transactional
	public void deleteIscrizione(int theId) {
		// da gestire le varie eccezioni
		iRepo.deleteById(theId);
	}

	@Override
	public Student findByNomeAndCognome(String nome, String cognome) {
		return repo.findByNomeAndCognome(nome, cognome);
	}


	@Override
	public List<Student> findByNomeLikeAndCognomeLike(String nome,String cognome) {
		if(nome == null && cognome != null) {
			return repo.findByCognomeLike(cognome);
		}
		else if(nome != null && cognome == null) {
			return repo.findByNomeLike(nome);
		}
		// da gestire il caso in cui tutti e 2 sono null
		return repo.findByNomeLikeAndCognomeLike(nome, cognome);
	}


	@Override
	public Optional<Iscrizione> findIscrizione(int theId) {
		return iRepo.findById(theId);
	}

}
