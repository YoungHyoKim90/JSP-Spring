package kr.or.ddit.springdi.collection;

import org.springframework.beans.factory.FactoryBean;

public class StringArrayFactoryBean implements FactoryBean<String[]>{

	@Override
	public String[] getObject() throws Exception {
		return new String[] {"arrayValue1", "arrayValue2"};
	}

	@Override
	public Class<?> getObjectType() {
		return String[].class;
	}

}
