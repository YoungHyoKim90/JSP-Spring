package kr.or.ddit.servlet03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServerTimeController {

	@RequestMapping("/05/serverTime")
	public String doGet(Optional<String> zone, Optional<String> locale, Locale requestLocale, TimeZone timeZone,
			Model model) {

		ZoneId zoneId = zone.map(zp -> ZoneId.of(zp)).orElse(timeZone.toZoneId());

		Locale loc = locale.map(lp -> Locale.forLanguageTag(lp)).orElse(requestLocale);

		LocalDate TODAY = LocalDate.now(zoneId);
		LocalDateTime CURRENT = LocalDateTime.now(zoneId);

		model.addAttribute("today", TODAY);
		model.addAttribute("current", CURRENT);
		model.addAttribute("zone", zoneId.getDisplayName(TextStyle.FULL, loc));

		return "jsonView";
	}
}

//	@GetMapping
//	public String doGet(
//			@RequestParam(required = false) String locale
//			,@RequestParam(required = false, defaultValue = "-1") int today
//			,@RequestParam(required = false, defaultValue = "-1") int current
//			,Optional<String> zone
//			,Model model
//			){
//		((HttpServletResponse) model).setHeader("Refresh", "1"); // 동기 요청에 대해서만 동작하는 헤더.
//		ZoneId zo = Optional.ofNullable(((ServletRequest) model).getParameter("zone"))
////				sugar syntax : 문법이 허용하는 범위내에서 간결하게 코드를 작성하는 방식.
//								.map(zp->ZoneId.of(zp))
//								.orElse(ZoneId.systemDefault());
//				
//		Locale loc = Optional.ofNullable(locale)
//								.filter(l->!l.isEmpty())
//								.map(lp->Locale.forLanguageTag(lp))
//								.orElse(locale.getDefault());
//		
//		LocalDate TODAY = LocalDate.now(zo);
//		LocalDateTime CURRENT = LocalDateTime.now(zo);
//		
//		model.addAttribute("today", TODAY);
//		model.addAttribute("current", CURRENT);
//		model.addAttribute("zone", zone.getDisplayName(TextStyle.FULL, locale));
//		
//		return "/jsonView.view";
//	}
//}
