package it.bit.accademiaspring.repo;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.bit.accademiaspring.model.Student;

public class StudentSpringRepoExtImpl implements StudentSpringRepoExt{
	
	private EntityManager manager;
	
	@Autowired
	public StudentSpringRepoExtImpl(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void patch(Student theStudent) {
		
		Student onDb = manager.getReference(Student.class, theStudent.getId());
		trySetField(theStudent.getNome() , onDb::setNome);
		trySetField(theStudent.getCognome() , onDb::setCognome);
		trySetField(theStudent.getDataDiNascita(), onDb::setDataDiNascita);
		trySetField(theStudent.getCF() , onDb::setCF);
		trySetField(theStudent.getTelefono() , onDb::setTelefono);
		trySetField(theStudent.getEmail() , onDb::setEmail);
		if(theStudent.getRegione() != null) {
			onDb.setRegione(theStudent.getRegione());
		}
		
	}
	private void trySetField(String newValue, Consumer<String> setter) {
		if(newValue != null && !newValue.equals("")) {
			setter.accept(newValue);
		}
	}
}
