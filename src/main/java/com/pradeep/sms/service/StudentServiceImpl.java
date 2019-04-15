package com.pradeep.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pradeep.sms.model.Student;
import com.pradeep.sms.model.Telephone;
import com.pradeep.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student save(Student student) {
		
		for(Telephone telephone:student.getTelephones()) {
			telephone.setStudent(student);
		}
		return studentRepository.save(student);
	}

	@Override
	public List<Student> fetch() {
		return studentRepository.findAll();
	}

	@Override
	public Student fetch(Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else {
			return null;
		}
	}

}
