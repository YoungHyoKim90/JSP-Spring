package kr.or.ddit.props.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import kr.or.ddit.vo.PropertyVO;

public class PropertyDAOImpl_FS implements PropertyDAO {
	
	private Properties dataSource;
	
	

	public PropertyDAOImpl_FS() {
		super();
		dataSource = new Properties();
		loadFromFile();
	}
	
	private void loadFromFile() {
		String name = "/kr/or/ddit/props/AlterDB.properties";
		try(
			InputStream is = this.getClass().getResourceAsStream(name);
		){
			dataSource.load(is);
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void storeToFile() {
		String name = "/kr/or/ddit/props/AlterDB.properties";
		URL url = this.getClass().getResource(name);
		try {
			Path path = Paths.get(url.toURI());
			OutputStream os = Files.newOutputStream(path);
			dataSource.store(os, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		}catch (IOException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
	private String generatePropertyName() {
		int maxNum = dataSource.keySet().stream()
								.map(Object::toString)
								.max(Comparator.naturalOrder())
								.map(mk->Integer.parseInt( mk.substring("prop".length()) ))
								.orElse(0);
		return MessageFormat.format("prop{0}", maxNum+1);
	}

	@Override
	public int insertProperty(PropertyVO prop) {
		String propertyName = generatePropertyName();
		prop.setPropertyName(propertyName);
		dataSource.setProperty(prop.getPropertyName(), prop.getPropertyValue());
		storeToFile();
		return 1;
	}

	@Override
	public PropertyVO selectProperty(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PropertyVO> selectProperties() {
		return dataSource.entrySet().stream()
				.map(en->{
					PropertyVO prop = new PropertyVO();
					prop.setPropertyName(en.getKey().toString());
					prop.setPropertyValue(en.getValue().toString());
					return prop;
				}).collect(Collectors.toList());
	}

	@Override
	public int updateProperty(PropertyVO prop) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProperty(String propertyName) {
		Object deletedValue = dataSource.remove(propertyName);
		storeToFile();
		return deletedValue == null ? 0 : 1;
	}

}





















