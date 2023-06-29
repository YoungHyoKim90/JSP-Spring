package kr.co.yhk;

public class S03HttpServletRequest {
/*
 * 1. HttpServletRequest의 여러가지 메서드
 * 
 * authenticate(HttpServletResponse response) : boolean을 반환한다. 현재 요청한 사용자가 ServletContext객체에 대한 인증을 하기 위한 컨테이너 로그인 메커니즘을 사용합니다.
 * 
 * changesessionId() : String을 반환한다. 현재 요청과 연관된 현재 세션의 id를 변경하여 새 세션 id를 반환합니다.
 * 
 * getContextPath() : String을 반환한다. 요청한 컨텍스트를 가리키는 URI를 반환합니다.
 * 
 * getCookies() : Cokie[] 을 반환한다. 클라이언트가 현재의 요청과 함께 보낸 쿠키 객체들에 대한 배열을 반환합니다.
 * 
 * getHeaderNames() : Enumeration<String> 현재의 요청에 포함된 헤더의 name속성을 enumeration으로 반환합니다.
 * 
 * getMethod() : String 요청한 URL의 컨텍스트 이름과 파일 경로까지 반환합니다.
 * 
 * getRequestURI() : String 요청한 URL에서 서블릿이나 JSP이름을 반환합니다.
 * 
 * getServletPath() : String 요청과 요청한 URL에서 서블릿이나 JSP이름을 반환합니다.
 * 
 * getSession() : HttpSession 현재의 요청과 연관된 세션을 반환합니다. 만약 세션이 없으면 새로 만들어서 반환합니다.
 * 
 * 2. HttpServletResponse의 여러가지 메서드
 * 
 * addCookie(Cookie cookie) : void 응답에 쿠키를 추가합니다.
 * 
 * addHeader(string name, String value) : void name과 value를 헤더에 추가합니다.
 * 
 * encodeURL(String url) : String  클라이언트가 쿠키를 지원하지 않을 때 세션id를 포함한 특정 URL을 인코딩합니다.
 * 
 * getHeaderNames() : Collection<String> 현재 응답의 헤더에 포함된 name을 얻어옵니다.
 * 
 * sendRedirect(String location) : void 클라이언트에게 리다이렉트(redirect)응답을 보낸 후 특정 URL로 다시 요청하게 합니다.
 * 
 * getPathInfo() : String 클라이언트가 요청 시 보낸 URL과 관련된 추가 경로 정보를 반환합니다.
 * 
 * =======================================================================================================================================
 * 
 * <form> 태그를 이용해 서블릿에 요청하기
 * 클라이언트에서 서버로 데이터를 전송하는 기능을 담당하는 <form>태그와 <input>태그의 기능은 자주 사용됨.
 * action : <form> 태그에서 데이터를 전송할 서블릿이나 JSP를 지정합니다.
 * 			서블릿으로 전송할 때는 매필 이름을 사용합니다.
 * encType : <form> 태그에서 전송할 데이터의 encoding타입을 지정합니다.
 * 			파일을 업로드할 때는 mulitpart/form-data로 지정합니다.
 * <input>
 * 
 */
}
