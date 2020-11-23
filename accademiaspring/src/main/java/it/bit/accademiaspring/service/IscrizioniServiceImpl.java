package it.bit.accademiaspring.service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bit.accademiaspring.model.Iscrizione;
import it.bit.accademiaspring.model.Student;
import it.bit.accademiaspring.repo.IscrizioniSpringRepo;

@Service
public class IscrizioniServiceImpl implements IscrizioniService{
	
	private IscrizioniSpringRepo repo;
	@Autowired
	public IscrizioniServiceImpl(IscrizioniSpringRepo repo ) {
		this.repo = repo;
	}
	@Override
	public Collection<Iscrizione> findAll() {
		return StreamSupport.stream(repo.findAll().spliterator(), false)
			    .collect(Collectors.toList());
	}
	public Iscrizione findById(int theId) {
		return repo.findById(theId).get();
	}
	@Override
	public void save(Iscrizione theIscrizione) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
		
	}
	@Override
	public void patch(Iscrizione theIscrione) {
		// TODO Auto-generated method stub
		
	}

}
