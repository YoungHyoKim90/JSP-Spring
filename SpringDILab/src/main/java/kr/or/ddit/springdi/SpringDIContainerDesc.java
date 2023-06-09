package kr.or.ddit.springdi;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.case2.view.Case2View;
import lombok.extern.slf4j.Slf4j;

/**
 * 스프링 컨테이너 사용 단계
 * 1. spring-context 의존성 추가(pom.xml)
 * 2. Spring Bean Configuration file 생성(Case3-Context.xml) : 컨테이너에 빈을 등록하기 위한 파일
 * 3. bean 엘리먼트로 객체(스프링 빈) 등록
 * 4. 의존성 주입(Dependency Injection) 구조로 등록된 빈들간의 관계 형성
 * 	1) Constructor Injection(생성자 주입) : 필수 주입인 경우 활용.
 * 			constructor-arg, c
 *  2) Setter Injection(셋터 주입)
 *  		property, p
 * 5. 어플리케이션의 엔트리 포인트에서 ConfigurableApplicationContext 의 구현체(컨테이너) 객체 생성
 * 	1) standalone : main 메소드에서 처음 생성.
 *  2) webapp : server 가 구동되는 시점에 대한 이벤트 처리 필요.
 * 6. container.getBean(검색조건-id/type) 으로 필요 객체 주입.
 * 7. 컨테이너 종료 설정(registerShutdownHook)  
 *
 * 스프링 컨테이너의 빈 관리 특성
 * 1. 특별한 설정(scope)이 없는 한 모든 빈을 싱글턴 구조로 관리됨.
 * 		singleton : 해당 빈의 인스턴스가 하나로 공유되는 구조.
 * 		prototype : (+lazy) 주입되기 전까지 인스턴스 생성을 지연시키고, 주입될때마다 새로운 인스턴스가 주입됨.
 * 		request/session (web app 에서 사용됨)
 *  2. 특별한 설정(lazy-init)이 없는 한 컨테이너가 초기화될때 등록된 모든 빈의 인스턴스를 일시에 생성함.
 *  3. depends-on 으로 직접 생성 순서를 설정할 수도 있음. 주의! 주입이 되지는 않음.
 */
@Slf4j
public class SpringDIContainerDesc {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new GenericXmlApplicationContext("classpath:kr/or/ddit/case2/conf/Case2-Context.xml");
		context.registerShutdownHook();
		
		Case2View view = context.getBean(Case2View.class);
		
		String content = view.generateContent("d001");
		
		log.info(content);
	}
}


























