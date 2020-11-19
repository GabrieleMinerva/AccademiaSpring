package it.bit.accademiaspring.controllers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import it.bit.accademiaspring.dto.CourseDTO;
import it.bit.accademiaspring.dto.IscrizioneDTO;
import it.bit.accademiaspring.dto.StudentDTO;
import it.bit.accademiaspring.model.Course;
import it.bit.accademiaspring.model.Lezione;
import it.bit.accademiaspring.model.Student;
import it.bit.accademiaspring.repo.LezioneSpringRepo;
import it.bit.accademiaspring.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/course")
public class CourseController {
	private CourseService courseService;
	

	
	@Autowired
	public CourseController(CourseService service) {
		courseService = service;
	
	}
	
	@GetMapping()
	public Iterable<CourseDTO> findAll() {
		return courseService.findAll().stream().map(CourseDTO::new).collect(Collectors.toList());
	}

	@GetMapping("/{courseId}")
	public CourseDTO getCourse(@PathVariable int courseId) {
		
		Course theCourse = courseService.findById(courseId)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
		
		return new CourseDTO(theCourse);
	}
	
	@GetMapping("/iscrizioni/{courseId}")
	public Iterable<IscrizioneDTO> getCourseIsc(@PathVariable int courseId) {
		
		Course theCourse = courseService.findById(courseId)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
		Collection <IscrizioneDTO> listaIsc = theCourse.getIscrizioni()
				.stream().map(IscrizioneDTO::new).collect(Collectors.toList());
		
		return listaIsc;
	}
	
	@PostMapping()
	public void addCourse(@RequestBody CourseDTO theCourseDTO ) {
		Course theCourse = theCourseDTO.toCourse();
	//	theCourse.setAulaPreferita(Course);
		courseService.save(theCourse);
		courseService.creaLezioni(theCourseDTO, theCourse);
		

	}
	
	@PutMapping()
	public CourseDTO updateCourse(@RequestBody CourseDTO theCourseDTO) {
		
		courseService.save(theCourseDTO.toCourse());
		return theCourseDTO;
	}

	@DeleteMapping("/{courseId}")
	public String deleteCourse(@PathVariable int courseId) {
		
		Course tempCourse = courseService.findById(courseId)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
		
		courseService.deleteById(courseId);
		return "Deleted course id - " + courseId;
	}
	@PatchMapping()
	public void patch(@RequestBody CourseDTO theCourseDTO) {
		courseService.patch(theCourseDTO.toCourse());
	}

}
