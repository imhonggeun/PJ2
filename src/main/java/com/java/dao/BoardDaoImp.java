package com.java.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.java.dto.TestDTO;
import com.java.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardDaoImp implements BoardDao {
	
	private final BoardMapper boardMapper;

	@Override
	public List<TestDTO> findList(String accept) {
		return boardMapper.findlist(accept);
	}

}
