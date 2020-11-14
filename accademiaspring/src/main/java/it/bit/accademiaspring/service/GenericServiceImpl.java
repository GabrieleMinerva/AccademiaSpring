package it.bit.accademiaspring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class GenericServiceImpl<T> implements GenericService<T>{
	private CrudRepository<T, Integer> repo;
	
	@Autowired
	public GenericServiceImpl(CrudRepository<T, Integer> repo) {
		this.repo = repo;
	}
	
	@Override
	public Iterable<T> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<T> findById(int theId) {
		return repo.findById(theId);
	}

	@Override
	public void save(T t) {
		repo.save(t);
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
	}

	@Override
	public void patch(T theId) {
		
	}
	
}
