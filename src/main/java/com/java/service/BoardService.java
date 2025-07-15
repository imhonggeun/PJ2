package com.java.service;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;

public interface BoardService {

	String findList(Model model, HttpServletRequest req); // 전체 리스트

	String input(HttpServletRequest req);// 글추가

	String detail(Model model, HttpServletRequest req); // 제목 클릭시 글 수정화면

	String edit(HttpServletRequest req); // 글 수정 완료

	String accept(HttpServletRequest req); // 승인,미승인 처리

}
