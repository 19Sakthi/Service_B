package com.example.Service_B.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_B.ServiceInter.StudentServiceInterService;
import com.example.Service_B.dto.StudentDto;


@RestController
@Slf4j
public class StudentControllerService {

	@Autowired
	StudentServiceInterService studentServiceInterService;

	@Autowired
	ObjectMapper objectMapper;

	@PostMapping("/saveStudentB")
	public StudentDto saveStudentB(@RequestBody StudentDto studentDto) {

		log.info("Received request to save Student: {}", studentDto);

		StudentDto savedStudentDto=studentServiceInterService.saveStudent(studentDto);

		log.info("Student saved successfully: {}", studentDto);

		return savedStudentDto;
	}

}
