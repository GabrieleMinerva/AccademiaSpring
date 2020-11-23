package it.bit.accademiaspring.repo;

import org.springframework.data.repository.CrudRepository;

import it.bit.accademiaspring.model.Iscrizione;
import org.springframework.stereotype.Component;

@Component
public interface IscrizioniSpringRepo extends CrudRepository<Iscrizione, Integer> {

}
