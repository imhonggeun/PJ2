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

	@Override //전체 리스트 화면
	public List<TestDTO> findList(String accept) {
		return boardMapper.findlist(accept);
	}

	@Override //글 추가
	public TestDTO input(TestDTO testDto) {
		int status = boardMapper.input(testDto); //여기가 문제
		return (status ==1) ? testDto :null;
	}

	@Override // 제목 클릭시 글 수정화면
	public TestDTO findOne(int no) {			
		return boardMapper.findOne(no);
	}


	@Override // 글 수정 완료
	public int edit(TestDTO testDto) {
		return boardMapper.edit(testDto);
	}

	@Override
	public int accept(TestDTO testDTO) {
		return boardMapper.accept(testDTO);
	}

}
