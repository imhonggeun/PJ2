package com.java.controller;

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
	private final BoardService boardservice;
	
	@GetMapping("/") //전체 리스트
	public String findList(Model model,HttpServletRequest req) {
		return boardservice.findList(model,req);
	}
	@GetMapping("/input") //글 추가화면
	public String input() {
		return "input";
	}
	@PostMapping("/input") //글 추가
	public String input(HttpServletRequest req) {
		return boardservice.input(req);
	}
	@GetMapping("/detail") // 제목 클릭시 글 수정화면
	public String detail(Model model, HttpServletRequest req) {
		return boardservice.detail(model,req);
	}
	@PostMapping("/edit") // 글 수정 완료
	public String edit(HttpServletRequest req) {
		return boardservice.edit(req);
	}
	@GetMapping("/accept")
	public String accept(HttpServletRequest req) {
		return boardservice.accept(req);
	}
	

}
