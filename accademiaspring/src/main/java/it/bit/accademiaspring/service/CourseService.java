package it.bit.accademiaspring.service;

import java.util.Collection;
import java.util.Optional;

import it.bit.accademiaspring.dto.CourseDTO;
import it.bit.accademiaspring.enu.Orario;
import it.bit.accademiaspring.model.Aula;
import it.bit.accademiaspring.model.Course;

public interface CourseService {
	
	public Collection<Course> findAll();
	
	public Optional<Course> findById(int theId);
	
	public void save(Course theCourse);
	
	public void deleteById(int theId);
	
	public void patch(Course theCourse);
	
	public boolean creaLezione(Course course, Aula aula, Orario orario, String data);
	
	public void creaLezioni(CourseDTO courseDTO, Course course);
}
