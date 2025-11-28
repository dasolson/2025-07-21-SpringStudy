package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.FoodService;
import com.sist.vo.FoodVO;


public class FoodController {
	@Autowired
	private FoodService service;
	
	@GetMapping("food/list.do")
	public String food_list(String page, Model model) {
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		final int ROWSIZE = 12;
		List<FoodVO> list = service.foodListData((curpage*ROWSIZE)-(ROWSIZE-1), (curpage*ROWSIZE));
		int totalpage = service.foodTotalPage();
		
		// 블록별 처리
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1; 
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK; 
				
		if(endPage > totalpage)
			endPage = totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);		
		
		return "food/list";
	}
}
