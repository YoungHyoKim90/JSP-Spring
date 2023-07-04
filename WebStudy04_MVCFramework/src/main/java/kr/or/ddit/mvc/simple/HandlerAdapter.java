package kr.or.ddit.mvc.simple;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HandlerMapping 을 통해 검색된 command handler 를 호출하는 역할 담당.
 *
 */
public interface HandlerAdapter {
	/**
	 * command handler 를 호출하는 역할 담당.
	 * @param handler
	 * @param req
	 * @param resp
	 * @return localViewName 반환
	 * @throws ServletException
	 * @throws IOException
	 */
	public String invokeHandler(AbstractController handler, 
					HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
