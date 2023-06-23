package kr.or.ddit.props.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.exception.PersistenceException;
import kr.or.ddit.vo.PropertyVO;

public class PropertyDAOImpl_DB implements PropertyDAO {

	@Override
	public int insertProperty(PropertyVO prop) {
		
		return 0;
	}

	@Override
	public PropertyVO selectProperty(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyVO> selectProperties() {
		List<PropertyVO> propList = new ArrayList<>();
		try(
			Connection conn = ConnectionFactory.getConnection();
			Statement stmt = conn.createStatement();
		){
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION  ");
			sql.append(" FROM CUSTOM_PROPS                           ");
			ResultSet rs = stmt.executeQuery(sql.toString());
			while(rs.next()){
// 				entity(attribute) -> java object(property)
				PropertyVO prop = new PropertyVO();
				propList.add(prop);
				prop.setPropertyName(rs.getString("PROPERTY_NAME"));
				prop.setPropertyValue(rs.getString("PROPERTY_VALUE"));
				prop.setDescription(rs.getString("DESCRIPTION"));
			}
			rs.close();
			return propList;
		}catch (SQLException e) {
			throw new PersistenceException(e);
		}
	}

	@Override
	public int updateProperty(PropertyVO prop) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProperty(String propertyName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
