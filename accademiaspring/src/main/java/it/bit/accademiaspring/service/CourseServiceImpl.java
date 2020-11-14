package it.bit.accademiaspring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.bit.accademiaspring.dto.CourseDTO;
import it.bit.accademiaspring.dto.StudentDTO;
import it.bit.accademiaspring.enu.Orario;
import it.bit.accademiaspring.model.Aula;
import it.bit.accademiaspring.model.Course;
import it.bit.accademiaspring.model.Lezione;
import it.bit.accademiaspring.repo.AulaSpringRepo;
import it.bit.accademiaspring.repo.CourseSpringRepo;
import it.bit.accademiaspring.repo.LezioneSpringRepo;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseSpringRepo repo;
	private LezioneSpringRepo lRepo;
	private AulaSpringRepo aRepo;

	@Autowired
	public CourseServiceImpl(CourseSpringRepo cRepo, LezioneSpringRepo lRepo, AulaSpringRepo aRepo) {
		repo = cRepo;
		this.lRepo = lRepo;
		this.aRepo = aRepo;

	}

	@Override
	public Collection<Course> findAll() {
		return StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Optional<Course> findById(int theId) {
		return repo.findById(theId);
	}

	@Override
	public void save(Course theCourse) {
		repo.save(theCourse);
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
	}

	@Transactional
	public void patch(Course theCourse) {
		repo.patch(theCourse);
	}

	@Transactional
	@Override
	public boolean creaLezione(Course course, Aula aula, Orario orario, String data) {
		Aula a = aula;
		int i = 0;
		List<Aula> lista = null;
		while (true) {
			if (lRepo.findByAulaAndOrarioAndData(a, orario, data).size() == 0) {
				lRepo.save(new Lezione(orario, data, a, course));
				return true;
			} else {
				if (i == 0) {
					lista = StreamSupport.stream(aRepo.findAll().spliterator(), false).collect(Collectors.toList());
				}
				if (lista.size() == i || lista.size() < 2) {
					return false;
				}
				a = lista.get(i++);
			}
		}
	}

	@Transactional
	@Override
	public void creaLezioni(CourseDTO courseDTO, Course course) {
		String dt = courseDTO.getDataInizio(); // Start date.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(dt));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dt = sdf.format(c.getTime()); // dt is now the new date.
		Aula a = aRepo.findById(courseDTO.getIdAulaPreferita()).get();
		int i = 0;
		while (i < courseDTO.getNumeroLezioni()) {
			String dt2 = sdf.format(c.getTime());
			if (creaLezione(course, a, courseDTO.getOrarioPreferito(), dt2)) {
				i++;
			}
			c.add(Calendar.DATE, 1);
		}
	}
}
