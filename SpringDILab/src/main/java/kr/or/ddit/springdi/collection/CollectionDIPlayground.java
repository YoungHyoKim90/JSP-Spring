package kr.or.ddit.springdi.collection;

import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectionDIPlayground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
					new GnericXmlAplicationContext("classPath:kr/or/ddit/dbInfo.properties");
		context.registerShutdownHook();
		
		CollectionDIVO vo1 = context.getBean("vo1",CollectionDIVO.class)
		log.info("주입된 객체 : {}" , vo1);
		CollectionDIVO vo2 = context.getBean("vo2",CollectionDIVO.class)
		log.info("주입된 객체 : {}" , vo2);
	}
}
