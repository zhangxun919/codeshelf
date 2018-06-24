package cn.jansen.tree;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DemoTest {

	private ObjectMapper mapper = null;
	
	@Before
	public void before() {
		mapper = new ObjectMapper();
	}
	
	@Test
	public void convertStringToTreeNodeTest() {
		JsonNode rootNode = null;
		String jsonString = "{\"isAdult\":true,\"score\":[89,90,92],\"student\":{\"name\":\"jansen\",\"age\":22,\"birthdate\":936115200000}}";
		try {
			rootNode = mapper.readTree(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JsonNode studentNode = rootNode.path("student");
		System.out.println("student type:" + studentNode.getNodeType());
		System.out.println("student:" + studentNode.toString());
		System.out.println("student name:" + studentNode.get("name"));
		
		JsonNode isAdultNode = rootNode.path("isAdult");
		System.out.println("isAdult type:" + isAdultNode.getNodeType());
		System.out.println("isAdult:" + isAdultNode.toString());
		System.out.println("isAdult:" + isAdultNode.asBoolean());
		
		JsonNode scoreNode = rootNode.path("score");
		System.out.println("score type:" + scoreNode.getNodeType());
		System.out.println("score:" + scoreNode.toString());
	}
	
	@Test
	public void convertTreeNodeToString() {
		ObjectNode rootNode = mapper.createObjectNode();
		ArrayNode scoreNode = mapper.createArrayNode();
		scoreNode.add(80);
		scoreNode.add(90);
		scoreNode.add(92);
		rootNode.set("score", scoreNode);
		System.out.println(rootNode.toString());
	}
	
}
