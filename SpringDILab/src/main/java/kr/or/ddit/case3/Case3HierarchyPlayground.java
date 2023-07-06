package kr.or.ddit.case3;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.case3.view.Case3View;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case3HierarchyPlayground {
	public static void main(String[] args) {
		ConfigurableApplicationContext parent = 
				new ClassPathXmlApplicationContext("kr/or/ddit/case3/parent/Parent-Context.xml");
		ConfigurableApplicationContext child =
				new ClassPathXmlApplicationContext(
					new String[] {"kr/or/ddit/case3/child/Child-Context.xml"}
					, parent
				);
		
		Case3View view = child.getBean(Case3View.class);
		String content = view.generateContent("e001");
		log.info(" 생성된 메시지 : {} ", content);
	}
}
