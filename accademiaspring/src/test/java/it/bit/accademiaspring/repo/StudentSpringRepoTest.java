package it.bit.accademiaspring.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import it.bit.accademiaspring.dto.DataIscrizioniDTO;
import it.bit.accademiaspring.enu.Orario;
import it.bit.accademiaspring.model.Aula;
import it.bit.accademiaspring.model.Course;
import it.bit.accademiaspring.model.Iscrizione;
import it.bit.accademiaspring.model.Lezione;
import it.bit.accademiaspring.model.Regione;
import it.bit.accademiaspring.model.Student;
import it.bit.accademiaspring.service.CourseService;
import it.bit.accademiaspring.service.StudentService;

@Transactional
@SpringBootTest
class StudentSpringRepoTest {

private Student s1 = new Student("gabr+i*" , "Paol+i*no", "112111+111", "caa+iiao"
			, "11clqzd+saa@gmail.com" , "3211+1312", null, null, null, new Regione(1 , "Lombardia"), null );
private Student s2 = new Student("p+i*no" , "coppol+ino", "111+11111", "cai+iao"
			, "a" , "1232+1312", null, null, null, new Regione(1 , "Lombardia"), null );
//private Aula a1 = new Aula();
private Course c1 = new Course("chimica", 100, 20, true, null, null);
private DataIscrizioniDTO d1;
private Iscrizione i1;
@Autowired
EntityManager manager;	
@Autowired
StudentSpringRepo repo;
@Autowired
StudentService service;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		s1.setId(-1);
		s2.setId(-2);

		manager.persist(s1);
		manager.persist(s2);
		manager.persist(c1);

	}

	@AfterEach
	void tearDown() throws Exception {
		manager.remove(s1);
		manager.remove(s2);
		manager.remove(c1);
		
	}

	@Test
	void testFindByNomeLikeAndCognomeLike() {
		List <Student> listaStudentiLike = repo.findByNomeLikeAndCognomeLike("%+i%", "%+i%");
		assertEquals(2, listaStudentiLike.size());
		listaStudentiLike = repo.findByNomeLikeAndCognomeLike("%i*%", "%i*%");
		assertEquals(1, listaStudentiLike.size());
	}
	@Test
	void testCreaIscrizione() {
		d1= new DataIscrizioniDTO(-1,-1);
		int i = service.creaIscrizione(d1);
		assertTrue(manager.find(Iscrizione.class, i) != null);
		i1 = manager.getReference(Iscrizione.class , i);
		manager.remove(i1);
		assertTrue(manager.find(Iscrizione.class, i) == null);
	}
	@Test
	void testDeleteIscrizione() {
		d1= new DataIscrizioniDTO(-1,-1);
		int i = service.creaIscrizione(d1);
	//	assertTrue(manager.find(Iscrizione.class, i) != null);
		service.deleteIscrizione(i);
		assertTrue(manager.find(Iscrizione.class, i) == null);
	}

}
