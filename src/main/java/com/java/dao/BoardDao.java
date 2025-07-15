package com.java.dao;

import java.util.List;

import com.java.dto.TestDTO;


public interface BoardDao {

	public List<TestDTO> findList(String accept); //전체 리스트

	public TestDTO input(TestDTO testDto); // 글추가

	public TestDTO findOne(int no); //제목 클릭시 글 수정화면

	public int edit(TestDTO testDto); // 글 수정 완료

	public int accept(TestDTO testDTO); //승인,미승인 처리

}
