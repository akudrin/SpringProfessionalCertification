package com.example.demo.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Person;

@RestController
public class HelloController {

	@GetMapping(path = "/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		return "Hello, " + name + "!";
	}

	@PostMapping(path = "/goodbye")
	public String goodbye(@RequestBody Person p) {
		return "Goodbye, " + p.getName() + "!";
	}

	@GetMapping(path = "/get")
	public Person getPerson() {
		Person p = new Person();
		p.setName("Bill");
		return p;
	}

	@GetMapping(path = "/getall")
	public List<Person> getAllPersons() {
		Person p1 = new Person();
		p1.setName("Bill");

		Person p2 = new Person();
		p2.setName("John");

		return Arrays.asList(p1, p2);
	}

	@GetMapping(path = "/statustest")
	// manually/excplicitly inject response in order to change it
	public Person statusTest(HttpServletResponse response) {
		Person p1 = new Person();
		p1.setName("Bill");
		// response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		return p1;
	}

	@RequestMapping(value = "/imageV1", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)

	public void getImageV1(HttpServletResponse response) throws IOException {

		var imgFile = new ClassPathResource("images/demo.png");

		response.setContentType(MediaType.IMAGE_PNG_VALUE);
		// With StreamUtils we copy the data from the image to the response object
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}

	@RequestMapping(value = "/imageV2", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> getImageV2() throws IOException {

		var imgFile = new ClassPathResource("images/demo.png");
		byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
	}

}
