package kr.or.ddit.subject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AAMWPC.do") // 애너테이션 webServlet
public class AcademicAffairsManagementWelcomPageController extends HttpServlet {

	// 여기서 뭐해야해...!? 브라우저에서 요청을 받아서 다음 내용 연결해야지! 
	//doget으로 할건가? dopost로 할건가? dohandler로 해도 됨! 오키 그렇게 하자.
	// 솔직히 여기서 받는건 페이지 넘겨주는 것 밖에 없어서 doget이어도 충분할듯
	@Override
	public void init() throws ServletException {
		System.out.println("called init method");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("called doGet method");
		doHandle(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("called doPost method");
	
	}
	
//1) super는 자신이 상속받은 부모 클래스에 대한 레퍼런스 변수로, 부모 클래스의 멤버에 접근할 때 사용됩니다.
//주로 객체안에 있는 부모의 멤버변수와 자신의 멤버변수를 구별하기 위해 사용됩니다. 
//2) super( )는 자식 클래스의 생성자에서 부모 클래스의 생성자를 호출하기 위해서 사용됩니다. 
	
	@Override
	public void destroy() {
		System.out.println("called destroy method");
	
	}
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doGet과 doPost를 동시에 처리하기 위한 doHandle
		System.out.println("called doHandle method");
		req.setCharacterEncoding("UTF-8");
		// utf 8로 타입변경.
		//음 ... 로그인 데이터에 대한 DB가 없는데?
		
		
	}
	
}
