package it.bit.accademiaspring;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.test.context.junit4.SpringRunner;

import it.bit.accademiaspring.model.Regione;
import it.bit.accademiaspring.model.Student;
import it.bit.accademiaspring.repo.StudentSpringRepo;
import it.bit.accademiaspring.repo.StudentSpringRepoExtImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentSpringRepoExtImplTest {
	private Student s1 = new Student("gabri" , "Paolino", "11111111", "caiiao"
			, "11clqdsaa@gmail.com" , "321312", null, null, null, new Regione(1 , "Lombardia"), null );
	private Student s2 = new Student("pino" , null, "11111111", "caiiao"
			, "" , "12321312", null, null, null, new Regione(1 , "Lombardia"), null );
	@Autowired
	StudentSpringRepo spr;
	
	@Autowired
	EntityManager manager;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	@Transactional
	@BeforeEach
	void setUp() throws Exception {
		s1.setId(-1);
		s2.setId(-2);

		manager.persist(s1);


	}
	@Transactional
	@AfterEach
	void tearDown() throws Exception {
		Student sDel = manager.getReference(Student.class, s1.getId());
		manager.remove(sDel);
	}

	@Transactional
	@Test
	void testPatch() {
		spr.patch(s2);
		Student sTemp = manager.find(Student.class, s1.getId());
		assertEquals("pino", sTemp.getNome());
		assertEquals("Paolino", sTemp.getCognome());
	}
}
