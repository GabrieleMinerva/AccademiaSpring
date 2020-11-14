package it.bit.accademiaspring.service;

import java.util.Optional;

import it.bit.accademiaspring.model.Iscrizione;

public interface GenericService<T> {

	public Iterable<T> findAll();
	
	public Optional<T> findById(int theId);
	
	public void save(T t);
	
	public void deleteById(int theId);
	
	public void patch(T theId);
}
