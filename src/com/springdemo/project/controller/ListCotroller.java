package com.springdemo.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ListCotroller {
	@RequestMapping("/list")
	public String list(Model model) {
		return "list-page";
	}
}
