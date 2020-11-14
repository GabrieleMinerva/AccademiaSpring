package it.bit.accademiaspring.repo;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import it.bit.accademiaspring.model.Course;
import it.bit.accademiaspring.model.Iscrizione;
import it.bit.accademiaspring.model.Student;

public class CourseSpringRepoExtImpl implements CourseSpringRepoExt{

private EntityManager manager;
	
	@Autowired
	public CourseSpringRepoExtImpl(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void patch(Course theCourse) {
		
		Course onDb = manager.getReference(Course.class, theCourse.getId());
		trySetField(theCourse.getNomeCorso() , onDb::setNomeCorso);
		onDb.setCapienza(theCourse.getCapienza());
		onDb.setIscrizioniMin(theCourse.getIscrizioniMin());
		onDb.setFinanziato(theCourse.isFinanziato());
		if(!theCourse.getAulaPreferita().equals(null)) {
			onDb.setAulaPreferita(theCourse.getAulaPreferita());
		}
	}
	private void trySetField(String newValue, Consumer<String> setter) {
		if(newValue != null && !newValue.equals("")) {
			setter.accept(newValue);
		}
	}
}
