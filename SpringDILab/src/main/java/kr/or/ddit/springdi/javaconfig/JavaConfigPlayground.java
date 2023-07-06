package kr.or.ddit.springdi.javaconfig;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.springdi.sample.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaConfigPlayground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(SampleJavaConfig.class);
		context.registerShutdownHook();
		
		Foo foo = context.getBean(Foo.class);
		log.info(foo.toString());
	}
}
