package kr.or.ddit.props;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import kr.or.ddit.IndexServlet;

/**
 ** class path resource 검색 : ClassLoader
 *
 * A a = new A(); 1. 버츄얼 머신은 ClassLoader를 이용해서 A를 상수 메모리 공간(삭제불가, 변경불가)에 적재를 한다.
 * 2. 인스턴스하나를 생성한다. 3. 생성된 인스턴스를 힙메모리에 적재한다. *힙메모리는 가비지컬렉터에 의해 관리 된다. 4. 주소 할당.
 *
 * properties 파일용 API : Properties, ResourceBundle
 *
 */
class PropertiestTest {

	@Test
	void readTest() {
		String qualifiedName = "/kr/or/ddit/props/AlterDB.properties";
		try (InputStream is = IndexServlet.class.getResourceAsStream(qualifiedName);

		) {
			Properties props = new Properties();
			props.load(is);

			props.forEach((k,v)->{
				
				System.out.printf(" %s : %s \n", k,v);
				
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
	
	@Test
	void writeTest() {
		String qualifiedName = "/kr/or/ddit/props/AlterDB.properties";
		
		URL url = IndexServlet.class.getResource(qualifiedName);
		String realPath = url.getFile(); // reql path
		File file = new File(realPath);
		try (
//			InputStream is = IndexServlet.class.getResourceAsStream(qualifiedName);
			FileOutputStream fos = new FileOutputStream(file);
		) {
			Properties props = new Properties();
//			props.load(is);
			props.setProperty("prop2", "prop value 2");
			props.store(fos, "임시 저장 프로퍼티");

//			props.forEach((k,v)->{
//				System.out.printf(" %s : %s \n", k,v);
//			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
	

}
