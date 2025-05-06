package com.example.Service_B.utility;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ComponentScan(basePackages = "Service B")
@Data
public class ResponseStructure {

	int status;
	String message;
}
