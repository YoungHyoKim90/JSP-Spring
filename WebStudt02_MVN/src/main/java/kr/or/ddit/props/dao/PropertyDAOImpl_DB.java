package kr.or.ddit.props.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.exception.PersistenceException;
import kr.or.ddit.vo.PropertyVO;

public class PropertyDAOImpl_DB implements PropertyDAO {

	@Override
	public int insertProperty(PropertyVO prop) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO custom_props (    ");
		sql.append(" 	    property_name          ");
		sql.append(" 	    , property_value       ");
		sql.append(" 	    , description          ");
		sql.append(" 	) VALUES (                 ");
		sql.append(" 	     ?                     ");
		sql.append(" 	   , ?                     ");
		sql.append(" 	   , ?                     ");
		sql.append(" 	)                          ");
		
		try (
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, prop.getPropertyName());
			pstmt.setString(2, prop.getPropertyValue());
			pstmt.setString(3, prop.getDescription());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e);
		}
		
	}

	@Override
	public PropertyVO selectProperty(String propertyName) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION  ");
		sql.append(" FROM CUSTOM_PROPS                           ");
		sql.append(" WHERE PROPERTY_NAME = ? ");
		try(
			Connection conn = ConnectionFactory.getConnection();
//			Statement stmt = conn.createStatement();	
//				선컴파일된 쿼리 객체 : 쿼리 파라미터를 리터럴로 대체함. pstmt.setXXX(파라미터인덱스, 리터럴);
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		){
			String query = MessageFormat.format(sql.toString(), propertyName);
			System.out.printf("실행 쿼리 : %s\n", query);
//			ResultSet rs = stmt.executeQuery(query);
			pstmt.setString(1, propertyName);
			ResultSet rs = pstmt.executeQuery();
			PropertyVO prop = null;
			if(rs.next()) {
				prop = new PropertyVO();
				prop.setPropertyName(rs.getString("PROPERTY_NAME"));
				prop.setPropertyValue(rs.getString("PROPERTY_VALUE"));
				prop.setDescription(rs.getString("DESCRIPTION"));
			}
			return prop;
		}catch (SQLException e) {
			throw new PersistenceException(e);
		}
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
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM CUSTOM_PROPS WHERE PROPERTY_NAME = ?");
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, propertyName);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e);
		}
	}

}




















