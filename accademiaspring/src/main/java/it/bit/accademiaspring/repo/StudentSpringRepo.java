package it.bit.accademiaspring.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import it.bit.accademiaspring.model.Student;
import org.springframework.stereotype.Component;


@Component
public interface StudentSpringRepo extends CrudRepository<Student, Integer> , StudentSpringRepoExt{
	    //Simple Query Methods
		
	    List<Student> findByDataDiNascita(String DataDiNascita);
	    List<Student> findByNome(String name);
	    List<Student> findByCognome(String cognome);

	    //Query Methods with Clauses and Exrpessions
	    Student findByNomeAndCognome(String nome, String cognome);
	    List<Student> findByCognomeIgnoreCase(String lastName);
	    List<Student> findByNomeLike(String likeString);
	    List<Student> findByCognomeLike(String likeString);
	    List<Student> findByNomeLikeAndCognomeLike(String nome, String cognome);
//	    StudentDTO findFirstByOrderByLastNameAsc();
//	    StudentDTO findTopByOrderByAgeDesc();
//	    List<StudentDTO> findTop3ByOrderByAgeDesc();

}
