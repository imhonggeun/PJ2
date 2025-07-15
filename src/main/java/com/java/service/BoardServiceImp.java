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

	@Override //전체 리스트
	public String findList(Model model, HttpServletRequest req) {		
		String accept = req.getParameter("accept");
		System.out.println(accept == null);
		if(accept == null|| accept == "") accept = "2";
		List<TestDTO> testDto = boardDao.findList(accept);
		System.out.print(testDto);
		model.addAttribute("result",testDto);
		return "list";
	}

	@Override // 글 추가 
	public String input(HttpServletRequest req) {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		TestDTO testDto = TestDTO.builder().title(title).content(content).build();
		//testDto = boardDao.input(testDto);
		boardDao.input(testDto);
			return "redirect:/";
	}

	@Override // 제목 클릭시 글 수정화면
	public String detail(Model model, HttpServletRequest req) {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			TestDTO testDTO = boardDao.findOne(no);
			model.addAttribute("result", testDTO);
			return "detail";
		}catch (NumberFormatException e) {
			e.printStackTrace();
			return "redirect:/";
		}
		
	}

	@Override //글 수정 완료
	public String edit(HttpServletRequest req) {
		int no = Integer.parseInt(req.getParameter("no"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		TestDTO testDto = TestDTO.builder().no(no).title(title).content(content).build();
		boardDao.edit(testDto);
		return "redirect:/";
	}

	@Override
	public String accept(HttpServletRequest req) {
		
			int no = Integer.parseInt(req.getParameter("no"));
			boolean accept = (req.getParameter("accept").equals("0")) ? true : false ;
			TestDTO testDTO = TestDTO.builder().no(no).accept(accept).build();
			boardDao.accept(testDTO);
			return "redirect:/";
		}
	}

