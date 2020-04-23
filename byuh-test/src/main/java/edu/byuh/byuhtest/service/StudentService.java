package edu.byuh.byuhtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.byuh.byuhtest.model.Student;
import edu.byuh.byuhtest.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	//CRUD
	
	/**
	 * Takes in a student object to save in the database
	 * @param student
	 */
	public void save(Student student) {
		// insert into student (emp_id, first_name, last_name) values (?, ?, ?)
		repo.save(student);
	}
	
	/**
	 * Returns a list of student objects form the database
	 * @return
	 */
	public List<Student> listAll() {
		// select * from student
		return repo.findAll();
	}
	
	/**
	 * Returns a student object from the database with the give id
	 * @param id
	 * @return
	 */
	public Student get(Long id) {
		// select * from student where id = ?
		return repo.findById(id).get();
	}
	
	/**
	 * Deletes a student form the database with the given id
	 * @param id
	 */
	public void delete(Long id) {
		// delete from student where id = ?
		repo.deleteById(id);
	}

}
