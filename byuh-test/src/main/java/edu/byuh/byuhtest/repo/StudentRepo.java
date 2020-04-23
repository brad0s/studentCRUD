package edu.byuh.byuhtest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.byuh.byuhtest.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{
	//interface to use JpaRepository built in queries

}
