package com.example.demo.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@PostMapping(path = "/test/{name}")
	public String test(@PathVariable String name, @RequestHeader String a, @RequestHeader String b,
			@RequestHeader String c, @RequestBody String body, HttpServletResponse response) {
		response.addHeader("test", "good");
		return name + " " + a + " " + b + " " + c + " " + body;
	}

	@GetMapping(path = "/all")
	public Map<String, String> all(@RequestHeader Map<String, String> map) {
		return map;
	}

	@GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public byte[] file() {
		byte[] file = new byte[100];
		return file;
	}
}
