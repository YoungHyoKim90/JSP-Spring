package kr.or.ddit.springdi.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CollectionDIVO {
	private List<String> sampleList;
	private String[] sampleArray;
	private Set<Object> sampleSet;
	private Map<String,Object> sampleMap;
	
	private Properties sampleProps;
}
