package com.sist.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*
 * Mapper == DAO == Service == serviceImpl == Controller == JSP
 * 
 * @Repository : DAO => SQL문장 처리
 * @Service    : DAO에서 부가적인 처리 => DAO 여러개를 묶어서 한번에 처리
 *                                       --------------------- 통합
 *               ----------------- 비지니스 로직  
 *                ==> BI
 * @Controller / @RestController
 *      |               |
 *      ----------------- 브라우저 연동 (화면 UI / 데이터 전송) 
 * @Component : AOP 클래스 / ChatManager / NewsManager
 * 
 * @Autowired : 주입
 * 
 * @GetMapping / @PostMapping
 */
import org.springframework.stereotype.Service;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO mDao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		String enPwd = encoder.encode(vo.getUserpwd());
		vo.setUserpwd(enPwd);
		mDao.memberInsert(vo);
	}
	
	
}
