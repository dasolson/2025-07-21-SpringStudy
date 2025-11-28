package com.sist.vo;

import lombok.Data;
// VO => Mapper (SQL) => DAO => Service => Controller => JSP
//                                         RestController => Vue
//                       | 오라클  | 기타 기능 추가    | 브라우저 전송
/*
 *   NO                                                 NUMBER(38)
	 POSTER                                             VARCHAR2(4000)
	 TITLE                                              VARCHAR2(4000)
	 CHEF                                               VARCHAR2(4000)
	 CHEF_POSTER                                        VARCHAR2(4000)
	 CHEF_PROFILE                                       VARCHAR2(4000)
	 INFO1                                              VARCHAR2(4000)
	 INFO2                                              VARCHAR2(4000)
	 INFO3                                              VARCHAR2(4000)
	 CONTENT                                            VARCHAR2(4000)
	 FOODMAKE                                           VARCHAR2(4000)
	 
	 @Controller : 화면 제어
	  --------- forward / redirect (JSP)
	 @RestController : 자바스크립트에 출력 값 전송
	  -------------- Ajax / Vue / Rest (JSP / HTML)
	                       ---- router
	                            return "forward:/index.html"
	                            일반 CDN / Module
	                            
	 -------------------------------------------------------- Model
	  Model : ~VO / ~DAO / ~service / ~Manager
	    |-------------------------------------------연결 (DispatcherServlet)
	  View (JSP/HTML) : 화면 출력 역할
	  
	  ==> 설정 => 동작에 대한 메뉴얼 작성 (XML, Properties)
	                                 |          |
	                              Framework   boot => .yml
	                                                   --- CI / CD
	                                                       들여쓰기
	                                                   server:
	                                                        port=80   Tab으로 들여쓰기
	                               	  
 */
@Data
public class RecipeDetailVO {
	private int no;
	private String poster, title, chef, chef_poster,  chef_profile, info1, info2, info3, content, foodmake;
}
