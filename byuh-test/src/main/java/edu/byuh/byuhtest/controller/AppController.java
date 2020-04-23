package edu.byuh.byuhtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.byuh.byuhtest.model.Student;
import edu.byuh.byuhtest.service.StudentService;

@Controller
public class AppController {
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * Returns the home page for app and displays a list of students
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String home(Model model) {
		// get a list of students to display in table on page
		List<Student> students = studentService.listAll();
		
		// add list to model to use in view
		model.addAttribute("students", students);
		
		// returns index view
		return "index";
	}
	
	/**
	 * Returns the form for creating a new student
	 * @param model
	 * @return
	 */
	@GetMapping("/new")
	public String createStudent(Model model) {
		// create new student object
		Student student = new Student();
		
		// add student object to model to use in view
		model.addAttribute("student", student);
		
		// returns newStudent view
		return "newStudent";
	}
	
	/**
	 * Saves the new student into the database
	 * @param student
	 * @return
	 */
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		// perform action to save student in database
		studentService.save(student);
		
		//redirect user to home page
		return "redirect:/";
	}
	
	/**
	 * Returns the form for editing a student
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable(name = "id") Long id, Model model) {
		
		// get student by id from pathVar
		Student student = studentService.get(id);
		
		// add student to model to use on view
		model.addAttribute("student", student);
		
		// return editStudent view
		return "editStudent";
	}
	
	/**
	 * Deletes a student from the database
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") Long id) {
		// gets id from path var to delete user
		studentService.delete(id);
		
		return "redirect:/";
	}

}
