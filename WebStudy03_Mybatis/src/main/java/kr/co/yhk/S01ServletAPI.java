package kr.co.yhk;

public class S01ServletAPI {

	/*
	 * 서블릿 API는 Servlet과 ServletConfig 인터페이스를 구현해 제공하며 GenericServlet추상 클래스가 이 두
	 * 인터페이스의 추상 메서드를 구현합니다. 그리고 이 Genericservlet을 다시 HttpServlet이 상속받습니다.
	 * 
	 * 서블릿 구성 요소
	 * Servlet interface
	 * init(), service(), destroy(), getServletIngo(), getServletconfig()를 선언합니다.
	 * 
	 * Servletconfig interface
	 * gietInitParameter(), getInitParameterNames(), gerServletContext(),getServletName()
	 * 
	 * 
	 * GenericServlet class
	 * service() override
	 * 
	 * HttpServlet class
	 * service(), doGet(),doPost(), doDelete(),doHead(), service()
	 * 
	 * 서블릿의 생명주기 메서드
	 * -> 서블릿 실행 단계마다 호출되어 기능을 수행하는 콜백 메서드를 말한다.
	 * 초기화 : 서블릿 요청 시 맨 처음 한번만 호출되며, 서블릿 생성 시 초기화 작업을 주로 수행
	 * init() 
	 * --> 실행 초기에 서블릿 기능 수행과 관련된 기능을 설정하는 용도로 사용.
	 * 작업수행 : 서블릿 요청 시 매번 호출됨, 클라이언트가 요청하는 작업을 수행한다.
	 * doget() 
	 * doPost()
	 * --> do로 시작하는 메서드는 서블릿의 핵심 기능을 처리하므로 반드시 구현해야 한다.
	 * 
	 * 종료 : 서블릿이 기능을 수행하고 메모리에서 소멸될 때 호출됩니다. 마무리 작업을 주로 수행합니다.
	 * destroy() 
	 */
}
