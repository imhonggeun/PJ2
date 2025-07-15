package com.java.service;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;

public interface BoardService {

	String findList(Model model, HttpServletRequest req); // 전체 리스트

	String input(HttpServletRequest req);// 글추가

}
