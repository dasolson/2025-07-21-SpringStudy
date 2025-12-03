package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface RecipeMapper {
	@Select("SELECT no, title, poster, num "
			+ "FROM (SELECT no, title, poster, rownum as num "
			+ "FROM (SELECT no, title, poster "
			+ "FROM recipe WHERE no IN(SELECT no FROM recipe "
			+ "INTERSECT SELECT no FROM recipeDetail) "
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	// recipe와 recipedetail에 동일한 no가 있는 데이터만 추출
	public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end);
	
    // 총페이지
	@Select("SELECT COUNT(*) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe "
			+ "INTERSECT SELECT no FROM recipeDetail)")
	public int recipeCount();
}
