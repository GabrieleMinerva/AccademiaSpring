package it.bit.accademiaspring.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bit.accademiaspring.dto.IscrizioneDTO;
import it.bit.accademiaspring.model.Iscrizione;
import it.bit.accademiaspring.service.IscrizioniService;
import it.bit.accademiaspring.service.IscrizioniServiceImpl;



@RestController
@RequestMapping("/api/iscrizioni")
public class IscrizioniController {

	private IscrizioniService iscrizioniService;
		
		@Autowired
		public IscrizioniController(IscrizioniService theIscrizioniService) {
			this.iscrizioniService = theIscrizioniService;
		}
		
		// expose "/employees" and return list of employees
		@GetMapping()
		public Iterable<IscrizioneDTO> findAll() {
			return iscrizioniService.findAll().stream().map(IscrizioneDTO::new).collect(Collectors.toList());
		}

		// add mapping for GET /employees/{employeeId}
		
		@GetMapping("/{iscrizioneId}")
		public IscrizioneDTO getIscrizione(@PathVariable int iscrizioneId) {
			
			Iscrizione theIscrizione = iscrizioniService.findById(iscrizioneId);
			
			if (theIscrizione == null) {
				throw new RuntimeException("Student id not found - " + iscrizioneId);
			}
			
			return new IscrizioneDTO(theIscrizione);
		}
		
		// add mapping for POST /employees - add new employee
		
//		@PostMapping("/students")
//		public StudentDTO addStudent(@RequestBody StudentDTO theStudentDTO ) {
//			
//			// also just in case they pass an id in JSON ... set id to 0
//			// this is to force a save of new item ... instead of update
//			Student theStudent = theStudentDTO.toStudent(); 
//		//	theStudent.setId(0);
//			
//			studentService.save(theStudent);
//			
//			return new StudentDTO (theStudent);
//		}
//		
//		// add mapping for PUT /employees - update existing employee
//		
//		@PutMapping("/students")
//		public StudentDTO updateStudent(@RequestBody StudentDTO theStudentDTO) {
//			
//			studentService.save(theStudentDTO.toStudent());
//			
//			return theStudentDTO;
//		}
//		@PatchMapping("/students")
//		public void patchStudent(@RequestBody StudentDTO theStudentDTO) {
//			studentService.patch(theStudentDTO.toStudent());
//		}
//		
//		// add mapping for DELETE /employees/{employeeId} - delete employee
//		
//		@DeleteMapping("/students/{studentId}")
//		public String deleteStudent(@PathVariable int studentId) {
//			
//			Student tempStudent = studentService.findById(studentId);
//			
//			// throw exception if null
//			
//			if (tempStudent == null) {
//				throw new RuntimeException("Student id not found - " + studentId);
//			}
//			
//			studentService.deleteById(studentId);
//			
//			return "Deleted student id - " + studentId;
//		}
}
