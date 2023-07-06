package kr.or.ddit.springdi.sample;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SamplePlayground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext("kr/or/ddit/sample/conf/Sample-Context.xml");
		context.registerShutdownHook();
		Foo foo1 = context.getBean(Foo.class);
		Foo foo2 = context.getBean(Foo.class);
//		log.info("{}", foo1 == foo2);
	}
}
