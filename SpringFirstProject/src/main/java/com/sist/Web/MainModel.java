package com.sist.Web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainModel {
    @RequestMapping("main/main.do")
    public String main_main(HttpServletRequest request, HttpServletResponse response) {
    	request.setAttribute("msg", "Hello Spring!!");
    	return "main/main";
    }
}
