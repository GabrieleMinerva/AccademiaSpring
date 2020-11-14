package it.bit.accademiaspring.service;

import java.util.Collection;

import it.bit.accademiaspring.model.Iscrizione;
import it.bit.accademiaspring.model.Student;

public interface IscrizioniService{
	
	public Collection<Iscrizione> findAll();
	
	public Iscrizione findById(int theId);
	
	public void save(Iscrizione theIscrizione);
	
	public void deleteById(int theIscrizione);
	
	public void patch(Iscrizione theIscrione);
}
