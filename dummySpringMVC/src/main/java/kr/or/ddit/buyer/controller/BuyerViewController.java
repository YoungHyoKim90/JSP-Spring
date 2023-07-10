package kr.or.ddit.buyer.controller;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller //컨트롤을 빈으로 등록한다.
public class BuyerViewController { // 하위 컨테이너에 등록됨.

	@Inject //주입주입 쭈입
	private BuyerService service;
	
	@PostConstruct // 객체 생성 후 필요한 모든 주입이 완료된 이후에 실행되는 콜백메서드
	public void init()	{
		log.info("주입된 service : {} " , service);
	}
	
	@RequestMapping(value = "/buyer/buyerView.do") //어떤 요청을 처리할 수 있다는 것을 매핑해줌.
	public String buyerViewHTML(@RequestParam(required = true) String what, Model model) {
		BuyerVO buyer = service.retrieveBuyer(what);
		model.addAttribute("buyer", buyer);
		return "buyer/buyerView";
	}
	
	@RequestMapping(value = "/buyer/buyerView.do", produces = MediaType.APPLICATION_JSON_VALUE)
	public String buyerViewJson(@RequestParam(required = true) String what, Model model) {
		BuyerVO buyer = service.retrieveBuyer(what);
		buyer.setDateTime(LocalDateTime.now());
		model.addAttribute("buyer", buyer);
		return "jsonView";
	}
}
//컨트롤러의 역활 5가지! 다시 확인하기! 어떤 어노테이션을 어떻게 사용하는지, 핸들러를 어떻게 사용할 수 있는지.

























