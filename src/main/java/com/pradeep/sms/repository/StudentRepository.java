package com.pradeep.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pradeep.sms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
