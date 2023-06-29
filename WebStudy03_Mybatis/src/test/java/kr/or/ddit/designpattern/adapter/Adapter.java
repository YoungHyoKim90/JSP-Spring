package kr.or.ddit.designpattern.adapter;

public class Adapter implements Target {

	private Adaptee adaptee; // has A 관계
	
	
	
	public Adapter(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		adaptee.specificRequest();

	}

}
