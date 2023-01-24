package edu.ifmo.tikunov.web.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class ViewController {
	@RequestMapping("/")
	public String home() {
		return "index.html";
	}

	@RequestMapping("/register")
	public String register() {
		return "index.html";
	}
}
