package com.java.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.java.dao.BoardDao;
import com.java.dto.TestDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImp implements BoardService{
	
	private final BoardDao boardDao;

	@Override
	public String findList(Model model, HttpServletRequest req) {
		
		String accept = req.getParameter("accept");
		System.out.println(accept == null);
		if(accept == null|| accept == "") accept = "2";
		List<TestDTO> testDto = boardDao.findList(accept);
		System.out.print(testDto);
		model.addAttribute("result",testDto);
		
		return "list";
	}

	@Override
	public String input(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
