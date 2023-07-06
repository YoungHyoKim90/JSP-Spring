package kr.or.ddit.case3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.case3.view.Case3View;

public class Case3Playground {
	public static void main(String[] args) {
		
		try(
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("kr/or/ddit/case3/conf/Case3-Context.xml");
		){
			context.registerShutdownHook();
			Case3View view = context.getBean(Case3View.class);
			String content = view.generateContent("b001");
			System.out.println(content);
		}
	}
}
