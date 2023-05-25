package kr.or.ddit.servlet01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿
 *	? 웹상에서 발생하는 요청을 받고 (req), 동적인 응답을 생성할 수 있는 (resp)
 *	자바 객체가 가져야 하는 조건에 대한 명세화 --> HttpServlet
 *
 *	서블릿 스펙에서 주요 객체
 *	1. HttpServlet : callback method (***callback -> 일정한 조건이 만들어 졌을때 자동으로 실행되는것)
 *	2. HttpServletRequest : Http 규칙에 따라 패키징 된 요청에 대한 정보 (서버기준으로)
 *	3. HttpServletResponse : Http 규칙에 따라 패키징 될 응답에 대한 정보 (서버기준으로)
 *	4. HttpSession : 하나의 클라이언트(해당 클라이언트가 사용 중인 에이전트)에 대한 정보를 가진 객체 *** 그사람이 사용하는 프로그램에 종류에 따라 1:1로 형성됨.
 ***Http 웹에서 동작하는 객체이다.
 *** 및의 5,6은 요청과 상관없다.
 *	5. ServletContext(서버당 하나이기 때문에 기본적으로 싱글턴이다.) :!서버와 컨텍스트!에 대한 정보.(톰캣 버전이 얼마인지, 컨택스트패스의 정보등을 확인)
 *	6. ServletConfig : 서블릿의 설정정보 , 부가정보(메타데이터)를 가짐, !하나의! 서블릿!에 대한 메타 정보!
 *** config 설정정보
 *
 *서블릿과 JSP에서 자주 사용되는 객체이다.
 *일반적으로 객체는 두가지이다 선택과 행동
 *
 *	callback은 우리가 호출하지 않는다. 그렇다면 누가? tomcat! 
 *	리퀘스트에서 누가 패키징해서 요청하나? tomcat!
 *	응답에 대한 것은 누가 패키징해서 응답하나? tomcat!
 *
 *	도데체 tomcat은 어떤 것을 하는 프로그램인가?
 *
 * 톰캣의 역활 *** 톰켓의 이름 WAS , Web Container, Servlet Container, JSP Container, Middle ware)
 * Container -> 그릇, 보관 
 * 			: 내부에서 관리되는 객체의 생명주기 관리자. (생성에서 사용, 소멸까지.)
 * Servlet Container : 내부에서 관리되는 Servlet 객체의 생명주기 관리자
 * JSP Container : 내부에서 관리되는 JSP 객체의 생명주기 관리자
 * 				   일반적인 컨테이너의 특징
 * 				   서블릿 컨테이너는 확장 CGI 방식에 따라 하나의 요청을 하나의 쓰레드로 처리함.
 * 				   톰켓은 쓰레드 풀링 구조 - 미리 쓰레드를 만들어 놓고 사용한다.					
 * 
 * 					1) 싱글턴 구조로 서블릿을 관리함.
 * 					2) 생명주기를 관리하는 과정에서 여러가지 상황에 대한 콜백 구조를 가짐.
 * 
 * Container 특징
 * 				1. 효율적관리를 위해 싱글턴으로 관리한다.
 * 				2. 객체를 관리하다 보면 이벤트가 많이 발생한다(이벤트 종류:객체 생성, 소멸)
 * 					이러한 이벤트를 callback method(이벤트마다 사용가능한 콜백메서드를 알아야한다.)를 이용하여 처리한다.
 *
 *	생명주기 : init, destory
 *	요청 : service, doXXXX (doget,dopost)
 *
 *** 멀티태스킹 - 	1 멀티프로세싱 	: 하나하나의 프로그램이 동시에 실행 
 *				2 멀티스레싱 	: 하나의 프로그램이 여러개로 쪼개져서 실행 => 톰캣방식.
 *** 확장 CGI방식
 *
 *
 */
@WebServlet("/desc") //Coc 패러다임 : 기존의 관행을 따라감. ***주로 Spring이 많이 함. Convention Over Configuration
public class DescriptionServlet extends HttpServlet {
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.printf("%s 서블릿 초기화\n",this.getClass().getSimpleName());
	}
	
	@Override // 해당 코드의 super가 없으면 doget이 실행 안됨.  http request method에 따른 분기자이다.
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서비스 실행");
		//super.service(req, resp); //분기!하는 코드를 가진것이 service이다.
		System.out.println("서비스 종료");
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 실행");
		resp.getWriter().printf(Thread.currentThread().getName());

		
	}
	@Override
	public void destroy() { // 언제 실행될지 알 수 없다. 서버를 꺼도 볼 수도 못 볼수도. 가비지 콜렉션 파트...)
		System.out.printf("%s 서블릿 소멸\n",this.getClass().getSimpleName());
	}
}































