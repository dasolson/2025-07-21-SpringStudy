package com.sist.service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO rDao;

	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		// TODO Auto-generated method stub
		return rDao.recipeListData(start, end);
	}

	@Override
	public int recipeCount() {
		// TODO Auto-generated method stub
		return rDao.recipeCount();
	}
}
