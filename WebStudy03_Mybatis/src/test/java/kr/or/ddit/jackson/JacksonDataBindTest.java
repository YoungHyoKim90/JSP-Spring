package kr.or.ddit.jackson;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class JacksonDataBindTest {
	
	@Test
	void serializeTest() throws StreamWriteException, DatabindException, IOException {
		Map<String, Object> target = new HashMap<>(); 
		target.put("message","요청 처리 완료. 결과 메시지 전송");
		target.put("numProp", 342);
		target.put("booleanProp", false);
		target.put("arryProp", new Object[]{"Sample", 23});
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(System.out, target);
	}
	
	@Test
	void unMarshallingTest() throws JsonMappingException, JsonProcessingException {
	//	JSON/XML ->Native Object
		
		String json = "{\"numProp\":342,\"booleanProp\":false,\"arryProp\":[\"Sample\",23],\"message\":\"요청 처리 완료. 결과 메시지 전송\"}";
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> target = mapper.readValue(json, HashMap.class);
		System.out.println(target);
		
	}
	
	@Test
	void marshallingTest() throws JsonProcessingException	{
	//	Native object => JSON/XML
		
		Map<String, Object> target = new HashMap<>(); //VO를 대체할때 VO는 properties가 제일 중요. properties(이름+값)
		target.put("message","요청 처리 완료. 결과 메시지 전송");
		target.put("numProp", 342);
		target.put("booleanProp", false);
		target.put("arryProp", new Object[]{"Sample", 23});
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(target);
		System.out.println(json);
		
	}

	@Test
	void test() {
		System.out.println("테스트 케이스 실행");
	}

}
