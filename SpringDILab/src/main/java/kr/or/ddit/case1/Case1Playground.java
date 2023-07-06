package kr.or.ddit.case1;

import kr.or.ddit.case1.view.Case1View;

public class Case1Playground {
	public static void main(String[] args) {
		Case1View view = new Case1View();
		String content = view.generateContent("a001");
		System.out.println(content);
	}
}
