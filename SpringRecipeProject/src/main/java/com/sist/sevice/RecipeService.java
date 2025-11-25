package com.sist.sevice;
import java.util.*;

import com.sist.vo.RecipeVO;
public interface RecipeService {
	public List<RecipeVO> recipeFindData(Map map);
	public int recipeFindCount(Map map);
}
