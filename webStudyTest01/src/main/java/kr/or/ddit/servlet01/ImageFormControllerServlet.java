package kr.or.ddit.servlet01;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imageTestForm.do")
public class ImageFormControllerServlet extends HttpServlet {


	private ServletContext application;
	//Provides access to the request information needed for a request made toan HTTP servlet.
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();

	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String folderPath = application.getInitParameter("medaiFolder");
			File folder = new File(folderPath);
		
		String [] imageFiles = folder.list((d,n) -> {
			String mime = application.getMimeType(n);
			
			return mime != null && mime.startsWith("image/");
			
			
		});
		
	req.setAttribute("imageFiles", imageFiles);
	
		String viewName = "WEB-INF/views/images/imageForm.jsp";
		
	req.getRequestDispatcher(viewName).forward(req, resp);
		
		
	}
}
