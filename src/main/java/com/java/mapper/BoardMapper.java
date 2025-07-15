package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

import com.java.dto.TestDTO;


@Mapper
public interface BoardMapper {

		@Select({"<script>"
				+ "SELECT no, title, content, accept, regDate FROM test "
				+ "<if test='accept == 1'>WHERE accept = 1</if> "
				+ "<if test='accept == 0'>WHERE accept = 0</if> "
				+ "</script>"})
		public List<TestDTO> findlist(String accept);

		@SelectKey(statementType = StatementType.PREPARED, statement = "select last_insert_id() as no", keyProperty = "no", before = false, resultType = int.class)
		@Insert("INSERT INTO test (title, content) VALUE (#{title}, #{content})")
		public TestDTO input(TestDTO testDto);
}
