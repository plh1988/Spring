package com.pradeep.sms.service;

import java.util.List;

import com.pradeep.sms.model.Student;

public interface StudentService {
	
	Student save(Student student);
	List<Student> fetch();
	Student fetch(Integer id);
}
