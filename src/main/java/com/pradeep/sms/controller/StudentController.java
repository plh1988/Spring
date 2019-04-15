package com.pradeep.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.sms.model.Course;
import com.pradeep.sms.model.Student;
import com.pradeep.sms.service.StudentService;

@RestController
@RequestMapping(value ="/smscloud")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		return studentservice.save(student);
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public List<Student> fetch(){
		return studentservice.fetch();
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> fetch(@PathVariable Integer id){
		if(id<=0) {
			return ResponseEntity.badRequest().build();
		}else{
			Student student = studentservice.fetch(id);
			if(student == null) {
				return ResponseEntity.notFound().build();
			}
			else {
				return ResponseEntity.ok(student);
			}
		}
	}
	
	@RequestMapping(value = "/student/{id}/course", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> fetchCourses(@PathVariable Integer id){
		if(id<=0) {
			return ResponseEntity.badRequest().build();
		}else{
			Student student = studentservice.fetch(id);
			if(student == null) {
				return ResponseEntity.notFound().build();
			}
			else {
				return ResponseEntity.ok(student.getCourses());
			}
		}
	}
}
