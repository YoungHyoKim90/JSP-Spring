package kr.or.ddit.springdi.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Data
public class Foo {
	private Bar bar; // 필수 객체
	private Baz baz; // 선택 객체
	
	public Foo() {
		super();
		log.info("{}, 객체 생성, 기본 생성자 사용", this.getClass().getSimpleName());
	}
	
	@Autowired
	public Foo(Bar bar) {
		super();
		this.bar = bar;
		log.info("{}, 객체 생성, 생성자를 통해 {}, 주입받음.", 
					this.getClass().getSimpleName(), bar.getClass().getSimpleName());
	}
	
	@Autowired
	public void setBaz(Baz baz) {
		this.baz = baz;
		log.info("setter 를 통해 {}, 주입받음.", baz.getClass().getSimpleName());
	}

	
}
