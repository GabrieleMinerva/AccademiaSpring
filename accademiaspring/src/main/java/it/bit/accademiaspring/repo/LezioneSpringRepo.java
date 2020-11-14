package it.bit.accademiaspring.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.bit.accademiaspring.enu.Orario;
import it.bit.accademiaspring.model.Aula;
import it.bit.accademiaspring.model.Course;
import it.bit.accademiaspring.model.Lezione;

public interface LezioneSpringRepo extends CrudRepository<Lezione, Integer>{
	 
	List<Lezione> findByAulaAndOrarioAndData(Aula aula, Orario orario, String data);
}
