package it.bit.accademiaspring.repo;

import org.springframework.data.repository.CrudRepository;

import it.bit.accademiaspring.model.Aula;

public interface AulaSpringRepo extends CrudRepository<Aula, Integer>{
	
}
