package kr.or.ddit.springdi.sample;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Bar {
	public Bar() {
		log.info("{}, 객체 생성, 기본 생성자 사용.", this.getClass().getSimpleName());
	}
}
