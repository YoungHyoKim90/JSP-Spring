package kr.or.ddit.case2.container;

import java.util.LinkedHashMap;
import java.util.Map;

import kr.or.ddit.case2.dao.Case2DAO;
import kr.or.ddit.case2.dao.Case2DAOImpl;
import kr.or.ddit.case2.dao.Case2DAOImpl_Mysql;
import kr.or.ddit.case2.service.Case2Service;
import kr.or.ddit.case2.service.Case2ServiceImpl;
import kr.or.ddit.case2.view.Case2View;

public class DependencyInjector {
	private static final DependencyInjector INSTANCE =  new DependencyInjector();
	public static DependencyInjector getInstance() {
		return INSTANCE;
	}
	private Map<Class<?>, Object> dummyContainer;
	private DependencyInjector(){
		dummyContainer = new LinkedHashMap<>();
		dummyContainer.put(Case2DAO.class, new Case2DAOImpl_Mysql());
		dummyContainer.put(Case2Service.class, new Case2ServiceImpl(
			(Case2DAO) dummyContainer.get(Case2DAO.class)	
		));
		dummyContainer.put(Case2View.class, new Case2View());
		Case2View view = (Case2View) dummyContainer.get(Case2View.class);
		view.setService((Case2Service) dummyContainer.get(Case2Service.class));
	}
	
	public static <T> T dependencyInject(Class<T> type) {
		return (T) INSTANCE.dummyContainer.get(type);
	}
}




































