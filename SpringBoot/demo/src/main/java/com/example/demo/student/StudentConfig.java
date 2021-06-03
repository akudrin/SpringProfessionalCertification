package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student mariam = new Student("Mariam", "mairam.jam@hotmail.com", LocalDate.of(1990, 1, 5));

			Student alex = new Student("Alex", "alex.jam@hotmail.com", LocalDate.of(1992, 3, 7));

			repository.saveAll(List.of(mariam, alex));

		};
	}

}
