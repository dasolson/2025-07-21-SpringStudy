package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 모든 Controller에 대한 예외 처리 = 공통기반 (공통 예외처리)
@ControllerAdvice
public class DataBoardCommonsException {
	@ExceptionHandler(RuntimeException.class)
	public void RuntimeException(RuntimeException ex) {
		System.out.println("===== 오류 발생 =====");
		ex.printStackTrace();
	}
	
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("===== 오류 발생 =====");
		ex.printStackTrace();
	}
}
