package com.example.Service_B.controller;

import com.example.Service_B.dto.StudentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StudentConsumer {

    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics = "Student_Service",groupId = "My_Group")
    public void saveStudent(String studentDtoR) {

        log.info("Received message from Kafka topic 'Student_Service': {}",studentDtoR);

        try {
            StudentDto studentDto=objectMapper.readValue(studentDtoR, StudentDto.class);

            log.info("Successfully deserialized Kafka message to StudentDtoB: {}", studentDto);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

