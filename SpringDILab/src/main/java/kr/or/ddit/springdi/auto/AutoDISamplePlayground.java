package kr.or.ddit.springdi.auto;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AutoDISamplePlayground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new GenericXmlApplicationContext("classpath:kr/or/ddit/auto/conf/AutoDI_Sample-Context.xml");
		context.registerShutdownHook();
	}
}
