package kr.or.ddit.case2;

import kr.or.ddit.case2.container.DependencyInjector;
import kr.or.ddit.case2.view.Case2View;

public class Case2Playground {
	public static void main(String[] args) {
		Case2View view = DependencyInjector.dependencyInject(Case2View.class);
		String content = view.generateContent("b001");
		System.out.println(content);
	}
}
