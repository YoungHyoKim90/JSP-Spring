package kr.or.ddit.springdi.collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("info1")
@Setter
@ToString
public class DBInfoVO {
//	@Value("#{dbInfo['maindb.driverClassName']}")
	@Value("${maindb.driverClassName}")
	private String driverClassName;
//	@Value("#{dbInfo['maindb.url']}")
	@Value("${maindb.url}")
	private String url;
	private String user;
	private String password;
	
	private int initialSize;
	private int maxTotal;
	private long maxWait;
}
