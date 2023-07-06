package kr.or.ddit.springdi.collection;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ColledtionDIPlayground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				new GenericXmlApplicationContext("classpath:kr/or/ddit/collection/CollectionDI-Context.xml");
		context.registerShutdownHook();
		
		CollectionDIVO vo1 = context.getBean("vo1", CollectionDIVO.class);
		log.info("주입된 객체 : {}", vo1);
		CollectionDIVO vo2 = context.getBean("vo2", CollectionDIVO.class);
		log.info("주입된 객체 : {}", vo2);
	}
}
