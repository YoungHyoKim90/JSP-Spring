package kr.or.ddit.props;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.jupiter.api.Test;

/**
 ** class path resource 검색 : ClassLoader
 *
 * A a = new A(); 1. 버츄얼 머신은 ClassLoader를 이용해서 A를 상수 메모리 공간(삭제불가, 변경불가)에 적재를 한다.
 * 2. 인스턴스하나를 생성한다. 3. 생성된 인스턴스를 힙메모리에 적재한다. *힙메모리는 가비지컬렉터에 의해 관리 된다. 4. 주소 할당.
 *
 * properties 파일용 API : Properties, ResourceBundle
 *
 */
class ResourceBundleTest {

	@Test
	void readTest() {

		String baseName = "kr.or.ddit.messages.Message";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, Locale.ENGLISH);
		Enumeration<String> keys = bundle.getKeys();
		
		//ResourceBundle 은 필수적으로 Locale하고 연관을 갖는다.

		while (keys.hasMoreElements()) {
			String msgCode = (String) keys.nextElement();
			String msg = bundle.getString(msgCode);
			System.out.printf(" %s : %s \n", msgCode, msg);
	//그냥 데이터를 가져온다면 번들이 예외처리가 없어서좋다.
		}

	}

}
