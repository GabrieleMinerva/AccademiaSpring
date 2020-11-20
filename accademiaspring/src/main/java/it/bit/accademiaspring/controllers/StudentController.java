package it.bit.accademiaspring.controllers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import it.bit.accademiaspring.dto.DataIscrizioniDTO;
import it.bit.accademiaspring.dto.IscrizioneDTO;
import it.bit.accademiaspring.dto.StudentDTO;
import it.bit.accademiaspring.model.Iscrizione;
import it.bit.accademiaspring.model.Student;
import it.bit.accademiaspring.service.StudentService;
import it.bit.accademiaspring.service.StudentServiceImpl;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/students")
public class StudentController {

private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService theStudentService) {
		studentService = theStudentService;
	}

	@GetMapping()
	public Iterable<StudentDTO> findAll() {
		return studentService.findAll().stream().map(StudentDTO::new).collect(Collectors.toList());
	}
	
	@GetMapping("/{studentId}")
	public StudentDTO getStudent(@PathVariable int studentId) {
		
		Student theStudent = studentService.findById(studentId)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
		
		return new StudentDTO(theStudent);
	}
	
	@PostMapping()
	public StudentDTO addStudent(@RequestBody StudentDTO theStudentDTO ) {
		
		Student theStudent = theStudentDTO.toStudent(); 
		studentService.save(theStudent);
		return new StudentDTO (theStudent);
	}
	
	@PutMapping()
	public StudentDTO updateStudent(@RequestBody StudentDTO theStudentDTO) {
		
		studentService.save(theStudentDTO.toStudent());
		
		return theStudentDTO;
	}
	@PatchMapping()
	public void patchStudent(@RequestBody StudentDTO theStudentDTO) {
		studentService.patch(theStudentDTO.toStudent());
	}
	
	@DeleteMapping("/{studentId}")
	public void deleteStudent(@PathVariable int studentId) {
		
		Student tempStudent = studentService.findById(studentId)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
		
		studentService.deleteById(studentId);
	}
	@PostMapping("/iscrizioni")
	public void creaDataIscrizione(@RequestBody DataIscrizioniDTO isc ) {
		studentService.creaIscrizione(isc);
	}
	@DeleteMapping("/iscrizioni/{idIscrizione}")
	public void deleteIscrizione(@PathVariable int idIscrizione) {
		Iscrizione iscrizione = studentService.findIscrizione(idIscrizione)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
		studentService.deleteIscrizione(idIscrizione);
	}
	
	@GetMapping("/search")
	public StudentDTO findByNomeAndCognome(@RequestParam String nome, @RequestParam String cognome) {
		return new StudentDTO(studentService.findByNomeAndCognome(nome, cognome));
	}
	
	@GetMapping("/searchlike")
	public List<StudentDTO> findByNomeLikeAndCognomeLike(@RequestParam String nome, @RequestParam String cognome) {
		return studentService.findByNomeLikeAndCognomeLike(nome, cognome)
				.stream().map(StudentDTO::new).collect(Collectors.toList());
	}
}
