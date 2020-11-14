package it.bit.accademiaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.bit.accademiaspring.model.Regione;
import it.bit.accademiaspring.model.Student;
import it.bit.accademiaspring.repo.StudentSpringRepo;

@SpringBootApplication
public class AccademiaspringApplication implements CommandLineRunner {

	
	@Autowired
	StudentSpringRepo studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AccademiaspringApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
//		studentRepository.save(new Student(9, "cluadio", "paolino", "20000909", "caiiao"
//				, "clqdsa@gmail.com", "343712325", "Milano", "via laudio", "21333", new Regione(1,"sicilia"), "Impiegato"));
//		System.out.println(studentRepository.findByNome("cluadio"));
	}

}
