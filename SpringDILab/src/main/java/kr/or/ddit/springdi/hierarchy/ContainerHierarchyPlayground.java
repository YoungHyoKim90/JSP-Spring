package kr.or.ddit.springdi.hierarchy;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.springdi.sample.Bar;
import kr.or.ddit.springdi.sample.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContainerHierarchyPlayground {
	public static void main(String[] args) {
		ConfigurableApplicationContext parent = 
				new ClassPathXmlApplicationContext("kr/or/ddit/auto/conf/parent/Parent-Context.xml");
		ConfigurableApplicationContext child =
				new ClassPathXmlApplicationContext(
					new String[] {"kr/or/ddit/auto/conf/child/Child-Context.xml"}
					, parent
				);
		
		log.info("자식 컨테이너에서 주입받은 Bar : {}", child.getBean(Bar.class));
		log.info("자식 컨테이너에서 주입받은 Foo : {}",  child.getBean(Foo.class));
	}
}
