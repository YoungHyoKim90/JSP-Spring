package kr.or.ddit.enumpkg;

public enum BrowserType  {
	//상수의 집합 클래스.
	//순서가 있는 상수. 상수는 열거로 순차집합이다.
	//ENUM타입의 객체는 임의 생성이 불가능하다. - 외부에서 사용불가.
	//한번 결정된 값을 바꾸지 못한다.
WHALE("웨일"), EDG("엣지"), CHROME("크롬"), OTHERS("기타");
	
	private BrowserType(String browserName) {
		this.browserName = browserName;
	}

	private String browserName;
	
	public String getBrowserName() {
		return browserName;
	}
	
	public static BrowserType findBrowserType(String userAgent) {
		BrowserType finded = OTHERS;
		BrowserType[] values = values();
		for(BrowserType tmp : values) {
			if(userAgent.toUpperCase().contains(tmp.name())) {
				finded = tmp;
				break;
			}
		}
		return finded;
	}
}