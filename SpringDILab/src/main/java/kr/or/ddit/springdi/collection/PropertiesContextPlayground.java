package kr.or.ddit.springdi.collection;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertiesContextPlayground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext("kr/or/ddit/collection/AutoDI-Context.xml");
		context.registerShutdownHook();
		
		DBInfoVO info1 = context.getBean("info1", DBInfoVO.class);
		log.info("주입된 객체 : {}", info1);
//		DBInfoVO info2 = context.getBean("info2", DBInfoVO.class);
//		log.info("주입된 객체 : {}", info2);
	}
}
