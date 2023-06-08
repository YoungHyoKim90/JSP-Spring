package kr.or.ddit.javatime;

import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class Java8JavaTimeAPITest {

	@Test
	void test() {
		//1970.01.01 00:00:00 기준시로부터 몇 ms가 지났느냐로 시간을 환산. - epoch time 일반적으로는 표준시간이랑은 마지 않다.
		Date today = new Date();
		System.out.println(today);
		
		//ISO에서 협정된 표준 시 : GMT, UTC, immutable 객체
		LocalDate today2 = LocalDate.now();
		
		System.out.println(today2);
		
		LocalDateTime current = LocalDateTime.now();
		System.out.println(current);
		
		ZonedDateTime currentZ = ZonedDateTime.now(ZoneId.systemDefault());
	
		System.out.println(currentZ);
		
		ZonedDateTime currentZ2 = ZonedDateTime.now(ZoneId.of("Africa/Abidjan"));
	
		System.out.println(currentZ2);
		
		int currentYear = today2.getYear();
		Month currentMonth = today2.getMonth();
		
		System.out.println(MessageFormat.format("{0},{1}", currentYear,currentMonth));
		
		YearMonth currnetYearMonth = YearMonth.now();
		
		System.out.println(currnetYearMonth);
		
		YearMonth nextMonth =  currnetYearMonth.plusMonths(1);
		System.out.println(nextMonth);
		
		YearMonth beforeMonth =  currnetYearMonth.minusMonths(1);
		System.out.println(beforeMonth);
		
		System.out.println(today2.format(DateTimeFormatter.ofPattern("MMMM",Locale.CANADA_FRENCH))); 
		
	}

}
