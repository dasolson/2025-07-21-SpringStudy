package com.sist.main3;

import com.sist.main2.ApplicationContext;
import com.sist.main2.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app2.xml");
		Member m = (Member)app.getBean("mem");
		System.out.println("번호  : " + m.getNo());
		System.out.println("이름 : " + m.getHmen().getName());
		System.out.println("성별 : " + m.getHmen().getSex());
		System.out.println("주소 : " + m.getHmen().getAddress());
		System.out.println("전화 : " + m.getHmen().getPhone());
		
		Student s = (Student)app.getBean("std");
	}

}
