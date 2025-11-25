package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	/*
	 * @Select("SELECT no, title, poster, chef FROM recipe WHERE ${column} LIKE '%'||#{ss}||'%'")
		public List<RecipeVO> recipeFindData(Map map);
		
		@Select("SELECT COUNT(*) FROM recipe WHERE ${column} LIKE '%'||#{ss}||'%'")
		public int recipeFindCount(Map map);
	 */
	public List<RecipeVO> recipeFindData(Map map){
		return mapper.recipeFindData(map);
	}
	public int recipeFindCount(Map map) {
		return mapper.recipeFindCount(map);
	}
}
