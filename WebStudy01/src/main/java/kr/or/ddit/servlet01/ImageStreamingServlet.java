package kr.or.ddit.servlet01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageStreamingServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.printf("%s 서블릿 초기화\n", this.getClass().getSimpleName());
	}

	/*
	 * stream(byte or char) copy 1. 입력 request 2. 처리 3. 출력 response
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("doGet 실행");

		String folderPath = "D:/medias/images";
		String fileName = req.getParameter("image");

// 방법 1.
//		resp.setContentType("image/jpg");
//
//		File imageFile2 = new File(folderPath, fileName);
//
//      try (InputStream inputStream2 = new FileInputStream(imageFile2);
//                OutputStream outputStream = resp.getOutputStream()) {
//
//              byte[] buffer = new byte[1024];
//               int bytesRead;
//               while ((bytesRead = inputStream2.read(buffer)) != -1) {
//                   outputStream.write(buffer, 0, bytesRead);
//               }
//           }
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			File imageFile = new File(folderPath, fileName);
			resp.setContentType("image/jpeg"); // MIME Multipurpose Internet Mail Extensions
			resp.setContentLengthLong(imageFile.length()); // 파일의크기
			fis = new FileInputStream(imageFile);

			os = resp.getOutputStream();
			// 파일의 끝(파일포인터!)을 다 받을때까지 ! (-1!,null)
			byte[] buffer = new byte[1024];
			int cnt = -1; // EOF, EOS 문자
			while ((cnt = fis.read(buffer)) != -1) {
				os.write(buffer, 0, cnt); // 어디서부터 어디까지 읽을건지!
			}
		} finally {
			if(fis!=null)
				fis.close();
			if(os != null)
				os.close();
		}
	} // 이런 코드는 망한 코드라고 한다. -> 문제가 있는 코드를 만들고 해결! 하기 위해 써봄...
} // 리펙토링 -> MIME, LengthLong
// 코드의 예외가 발생하면 마지막 close가 사용되지 않는다. try,finall, if! 