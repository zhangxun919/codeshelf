package cn.jansen.start;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TreeModelDemo {
	
	private JsonNodeFactory  nodeFactory = null;
	private JsonFactory jsonFactory = null;
	private ObjectMapper mapper = null;
	
	@Before
	public void before() {
		nodeFactory = new JsonNodeFactory(false);
		jsonFactory = new JsonFactory();
		mapper = new ObjectMapper();
	}
	
	@Test
	public void testConvertBeanToJsonWithTreeModel() throws IOException {
		JsonGenerator generator = jsonFactory.createGenerator(System.out);
		
		ObjectNode album = nodeFactory.objectNode();
		album.put("title", "寂静的春天");
		
		ArrayNode links = nodeFactory.arrayNode();
		links.add("www.silentspring.com").add("www.silentspring.cn");
		album.put("links", links);
		
		ObjectNode artist = nodeFactory.objectNode();
		artist.put("name", "Jansen");
		artist.put("birthdate", "1987-03-14");
		album.put("artist", artist);
		
		mapper.writeTree(generator, album);
	}

}
