package kr.or.ddit.props.service;

import java.text.MessageFormat;
import java.util.List;

import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.props.dao.PropertyDAO;
import kr.or.ddit.props.dao.PropertyDAOImpl_DB;
import kr.or.ddit.vo.PropertyVO;

public class PropertyServiceImpl implements PropertyService{
	private PropertyDAO dao = new PropertyDAOImpl_DB();
	
	public boolean createProperty(PropertyVO prop){
		int count = dao.insertProperty(prop);
		return count > 0;
	}

	@Override
	public PropertyVO retrieveProperty(String propertyName) {
		PropertyVO prop = dao.selectProperty(propertyName);
		if(prop==null)
			throw new PKNotFoundException(MessageFormat.format("{0} 에 해당하는 데이터 없음.", propertyName));
		return prop;
	}

	@Override
	public List<PropertyVO> retrieveProperties() {
		return dao.selectProperties();
	}

	@Override
	public boolean modifyProperty(PropertyVO prop) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeProperty(String propertyName) {
		int count = dao.deleteProperty(propertyName);
		return count > 0;
	}
}




















