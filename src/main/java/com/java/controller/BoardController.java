package com.java.controller;

import java.util.Enumeration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class BoardController {
	private final BoardService Boardservice;
	
	@GetMapping("/") //전체 리스트
	public String findList(Model model,HttpServletRequest req) {
		return Boardservice.findList(model,req);
	}
	@GetMapping("/input") //글 추가
	public String input() {
		return "input";
	}
	@PostMapping("/input")
	public String input(HttpServletRequest req) {
		return Boardservice.input(req);
	}

}
