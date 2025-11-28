package com.sist.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 매개변수 있는 생성자
@NoArgsConstructor // 매개변수 없는 생성자
public class EmpVO {
	private int empno;
	private String ename, job;
}
