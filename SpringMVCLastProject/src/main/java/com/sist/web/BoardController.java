package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * 			3) HandlerMapping => 해당 Controller 찾기
 * 			4) 해당 기능을 수행하는 메소드 수행
 * 			5) request / model에 데이터를 담기 => DispatcherServlet이 받아서
 * 			6) ViewResolver => JSP를 찾아서 request 전송
 * 			7) JSP에서 화면 출력
 *   			=> JSP / Vue / ThymeLeaf / React
 *                                           | UI
 *                              | 다음주 => UI => 2주 정도 : CI/CD
 *                                우분투 : docker , docker-compose
 *                                        => minikube / jenkins
 *                                        
 *       JSP(요청) == DisaptcherServlet == HandlerMapping
 *                                              |
 *                                         @Controller (Model)
 *                                              |
 *                                            Mapper
 *                                            	|
 *                                             DAO
 *                                              |
 *                                           Service
 *                                              |
 *                                       DispatcherServlet  
 *                                              |
 *                                         ViewResolver
 *                                              |
 *                                             JSP       
 *       => DispatcherServlet : 모든 요청을 받아서 router
 *            => FrontController
 *            => 요청 : 응답 => 서빙
 *       => HandlerMapping : 어떤 모델을 호출 할 지 찾는 역할
 *       => @Controller / @RestController
 *            => 개발자 담당 : 비지니스 로직 (요청 처리)
 *                           => DAO / Service / VO
 *       => Model : JSP로 전송 할 데이터를 저장
 *                  addAttribute() => request.setAttribute()
 *       => ViewResolver : JSP를 찾아주는 역할
 *       => View : 화면 UI (JSP, HTML, Vue, React)
 *    -------------------------------------------------------------
 *       DI (주입) => 객체 생성 => 객체 소멸
 *                    | 필요한 데이터가 있는 경우 => 값을 채워준다
 *                    | setter / 생성자 => 멤버변수의 초기화
 *                    | 객체 생성시 호출 : init-method 
 *                    | 객체 소멸시 호출 : destory_method
 *                    | 사용자 정의 클래스X, MyBatis / JPA
 *                    | <bean id="" class=""
 *                        p:변수명=""/>
 *                      <bean id="" class=""
 *                        c:변수명=""/> => 생성자의 매개변수
 *       AOP : 공통 모듈 (모든 기능에서 사용이 되는 기능을 모아서 관리 => 필요시에 
 *       
 *             public void display1() { ===> 메소드 구분 (PointCut)
 *                 try {
 *                 	   @Before
 *                     -------- 1) @Around setAutoCommit(false)
 *                     1
 *                     2
 *                     3
 *                     -------- 2) commit()		
 *                 }catch {
 *                 	   4 ===> @After-Throwable rollback()
 *                 }finally {
 *                     @After disConnection()    
 *                 } 
 *                 return "" ===> @After-Returning => 출력
 *             }    
 *             
 *             public void display2() {
 *                 try {
 *                 
 *                 } catch {
 *                 
 *                 }
 *                 return ""
 *             }   
 *             
 *             JoinPoint : 어디서 사용 할 건지
 *             PointCut  : 어떤 메소드 안에 처리
 *             ----------- +
 *             => Advice    
 *             ---------- Aspect 
 *             
 *             => 위빙 : 모든 기능을 묶어서 호출
 *             => 사용자 정의는 거의 없다 (쿠키)
 *                ------------------
 *                이미 제작되어 있는 것들이 있다 : 트랜젝션 / 보안
 *             => public void boardInsert() {
 *             	      try {
 *                        getConnection()
 *                        setAutoCommit(false)
 *                        insert()
 *                        insert()
 *                        insert()
 *                        commit()
 *                    }catch {
 *                        rollback()
 *                    }finally {
 *                        setAutoCommit(ture)
 *                    }
 *                }   
 *                
 *                @Transactional
 *                public void boardInsert() {
 *                    insert()
 *                    insert()
 *                    insert()
 *                } 
 *                
 *      @Controller / @RestController
 *                     | 데이터 전송만 (JSON)
 *       | View 제어 => router => 화면 이동  
 *       
 *      @Controller + @ResponseBody => @RestController
 *                    ------------- spring5 이전
 *      
 *      @Pathvariable
 *         /board/list/1
 *          => *.do => / => boot는 기본 /
 *         
 *      @RequestBody => VO 
 *         => JSON => 객체로 변환
 *          axios.post('', {
 *          	name : this.name,
 *              subject : this.subject,
 *              content : this.content,
 *              pwd : this.pwd
 *          }) 
 *          
 *      @ResponseStatus => 응답 HTTP 상태
 *         => 200 : OK, 500, 404 ...
 *         
 *      => DI
 *      @Autowired : 스프링에 등록된 객체를 찾아 메모리 주소값 대입	
 *      
 *      => ResponseEntity : 응답 전체를 직접 제어	
 *         => HTTP 상태 코드, 헤더, 바디 ... => 제어 할 수 있는 객체
 *         => HttpStatus, Body 
 *      ----------------------------------------------------
 *      사용법 / 어떤 실행 / 어떤 데이터가 필요한가                                                                                                                                                           	
 */
@Controller
public class BoardController {
	@GetMapping("board/list.do")
	public String board_list(Model model) {
		model.addAttribute("main_jsp", "../board/list.jsp");
		return "main/main";
	}
	
	@GetMapping("board/insert.do")
	public String board_insert(Model model) {
		model.addAttribute("main_jsp", "../board/insert.jsp");
		return "main/main";
	}
	
	@GetMapping("board/update.do")
	public String board_update(int no, Model model) {
		model.addAttribute("no", no);
		model.addAttribute("main_jsp", "../board/update.jsp");
		return "main/main";
	}
	
	@GetMapping("board/detail.do")
	public String board_detail(int no, Model model) {
		model.addAttribute("no", no);
		model.addAttribute("main_jsp", "../board/detail.jsp");
		return "main/main";
	}
	
	
}
