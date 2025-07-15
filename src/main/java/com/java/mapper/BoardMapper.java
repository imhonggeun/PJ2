package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.java.dto.TestDTO;



@Mapper
public interface BoardMapper {
		//전체 리스트
		@Select({"<script>"
				+ "SELECT no, title, content, accept, regDate FROM test "
				+ "<if test='accept == 1'>WHERE accept = 1</if> "
				+ "<if test='accept == 0'>WHERE accept = 0</if> "
				+ "</script>"})
		public List<TestDTO> findlist(String accept);
		
		
		//글추가
		@SelectKey(statementType = StatementType.PREPARED, statement = "select last_insert_id() as no", keyProperty = "no", before = false, resultType = int.class)
		@Insert("INSERT INTO test (title, content) VALUE (#{title}, #{content})")
		public int input(TestDTO testDto);
		
		
		//클릭 시 해당 글 수정화면
		@Select("select no, title, content, accept, regDate FROM test Where No = #{No}")
		public TestDTO findOne(int no);

		//글 수정 완료
		@Update("UPDATE test SET title = #{title}, content = #{content} WHERE no = #{no}")
		public int edit(TestDTO testDto);

		//승인,미승인 처리
		@Update("UPDATE test SET accept = #{accept} WHERE no = #{no}")
		public int accept(TestDTO testDTO);
		
}
