package com.sist.vo;

import lombok.Data;

/*
 *  NO	NUMBER
	TITLE	VARCHAR2(4000 BYTE)
	POSTER	VARCHAR2(260 BYTE)
	CHEF	VARCHAR2(500 BYTE)
	LINK	VARCHAR2(100 BYTE)
	HIT	NUMBER
	LIKECOUNT	NUMBER
	JJIMCOUNT	NUMBER
	REPLYCOUNT	NUMBER
 */
@Data
public class RecipeVO {
	private int no;
	private String title, chef;
}
