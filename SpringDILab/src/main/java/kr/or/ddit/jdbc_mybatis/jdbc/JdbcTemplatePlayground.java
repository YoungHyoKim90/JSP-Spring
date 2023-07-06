package kr.or.ddit.jdbc_mybatis.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import kr.or.ddit.jdbc_mybatis.vo.PropertyVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JdbcTemplatePlayground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("kr/or/ddit/jdbc_mybatis/dataSource-context.xml");
		context.registerShutdownHook();
		
		JdbcTemplate template = context.getBean(JdbcTemplate.class);
		NamedParameterJdbcTemplate namedTemplate = context.getBean(NamedParameterJdbcTemplate.class);
		
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION ");
		builder.append(" FROM CUSTOM_PROPS                                 ");
		
		List<PropertyVO> propList = template.query(builder.toString(), new RowMapper<PropertyVO>() {
			@Override
			public PropertyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PropertyVO propVO = new PropertyVO();
				propVO.setPropertyName(rs.getString("PROPERTY_NAME"));
				propVO.setPropertyValue(rs.getString("PROPERTY_VALUE"));
				propVO.setDescription(rs.getString("DESCRIPTION"));
				return propVO;
			}
		});
		
		propList.forEach(p->log.info(p.toString()));
		
		builder.delete(0, builder.length());
		builder.append(" INSERT INTO CUSTOM_PROPS                                        ");
		builder.append(" (                                                               ");
		builder.append(" 	PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION                   ");
		builder.append(" )VALUES(                                                        ");
		builder.append(" 	:propertyName	, 	:propertyValue, 		:description	 ");
		builder.append(" )                                                               ");
		
		PropertyVO newProp = new PropertyVO();
		newProp.setPropertyName("쌔프롭");
		newProp.setPropertyValue("쌔프롭값");
		newProp.setDescription("설명");
		
		int cnt = namedTemplate.update(builder.toString(), new BeanPropertySqlParameterSource(newProp));
		
		log.info("insert count : {}", cnt);
	}
}














