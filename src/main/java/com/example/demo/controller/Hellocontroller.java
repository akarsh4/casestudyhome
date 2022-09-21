package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {
	@RequestMapping("/new")
	public String sayHi() {
		return "hai";
	}
}
