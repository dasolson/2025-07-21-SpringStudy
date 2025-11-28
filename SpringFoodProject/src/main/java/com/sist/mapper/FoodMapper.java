package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno, name, address, type, phone FROM menupan_food WHERE ${column} LIKE '%'||#{ss}||'%'")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT COUNT(*) FROM menupan_food WHERE ${column} LIKE '%'||#{ss}||'%'")
	public int foodFindCount(Map map);
	
	@Select("SELECT fno, name, address, type, phone, num "
			+ "FROM (SELECT fno, name, address, type, phone, rownum as num "
			+ "FROM (SELECT fno, name, address, type "
			+ "FROM menupan_food "
			+ "WHERE fno IN(SELECT fno FROM menupan_food INTERSECT "
			+ "SELECT fno FROM foodDetail) "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food "
			+ "WHERE fno IN(SELECT fno FROM menupan_food INTERSECT "
			+ "SELECT fno FROM foodDetail)")
	public int foodTotalPage();
}
