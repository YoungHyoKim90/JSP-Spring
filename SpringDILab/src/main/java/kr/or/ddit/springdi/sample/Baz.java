package kr.or.ddit.springdi.sample;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Baz {
	public Baz() {
		log.info("{}, 객체 생성, 기본 생성자 사용.", this.getClass().getSimpleName());
	}
}
