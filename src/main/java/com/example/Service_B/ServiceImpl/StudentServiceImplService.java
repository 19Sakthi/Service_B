package com.example.Service_B.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.Service_B.ServiceInter.StudentServiceInterService;
import com.example.Service_B.dto.StudentDto;
import com.example.Service_B.entity.StudentEntity;
import com.example.Service_B.repository.StudentRepositoryService;


@Service
@Slf4j
public class StudentServiceImplService implements StudentServiceInterService {

	@Autowired
	StudentRepositoryService studentRepositoryService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private ModelMapper modelMapper;

	public StudentDto  saveStudent(StudentDto studentDto) {

		log.info("Starting to save Student in DB: {}", studentDto);

		StudentDto savedStudentDto=convertEntityToDto(studentRepositoryService.save(convertDtoToEntity(studentDto)));

		log.info("Student saved in DB: {}",studentDto);

		StudentDto studentResponse =restTemplate.postForEntity("http://localhost:8082/saveStudent", savedStudentDto, StudentDto.class).getBody();

		log.info("Response received from Service A: {}", studentResponse);

		return studentResponse;
	}

	public StudentDto convertEntityToDto(StudentEntity studentEntity) {
		return modelMapper.map(studentEntity, StudentDto.class);
	}

	public StudentEntity convertDtoToEntity(StudentDto studentDto) {
		return modelMapper.map(studentDto, StudentEntity.class);
	}

}
