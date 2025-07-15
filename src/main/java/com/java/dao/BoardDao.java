package com.java.dao;

import java.util.List;

import com.java.dto.TestDTO;

public interface BoardDao {

	public List<TestDTO> findList(String accept); //전체 리스트

	public TestDTO input(TestDTO testDto); // 글추가

}
