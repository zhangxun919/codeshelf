package cn.jansen.tree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TreeDemo {
	
	private ObjectMapper mapper = null;
	
	@Before
	public void before() {
		mapper = new ObjectMapper();
	}
	
	@Test
	public void testJsonToTreeNode() throws FileNotFoundException, IOException {
		String originJson = IOUtils.toString(new FileReader("album.json"));
		// 将Json字符串读入内存并转化为tree类型
		JsonNode node = mapper.readTree(originJson);
		
		System.out.println("当前Node的类型为：" + node.getNodeType());
		System.out.println("当前Node是否是父亲节点：" + node.isContainerNode());
		// 迭代输出该父亲节点下面的所有子节点名称
		Iterator<String> fieldNames = node.fieldNames();
		while(fieldNames.hasNext()) {
			System.out.println(fieldNames.next());
		}
		System.out.println(node.get("title").asText());
		
		JsonNode songNode = node.get("songs");
		System.out.println("当前Node的类型为：" + songNode.getNodeType());
		System.out.println("当前Node是否是父亲节点：" + songNode.isContainerNode());
		Iterator<JsonNode> songElements = songNode.iterator();
		while(songElements.hasNext()) {
			JsonNode songs = songElements.next();
			System.out.println("当前Node的类型为：" + songs.getNodeType());
			System.out.println("当前Node是否是父亲节点：" + songs.isContainerNode());
			
			Iterator<String> songsFields = songs.fieldNames();
			while(songsFields.hasNext()) {
				String currentSong = songsFields.next();
				System.out.println(currentSong + "-" + songs.get(currentSong));
			}
		}
	}
	
	@Test
	public void testJsonToTreeNode2() throws FileNotFoundException, IOException {
		String originJson = IOUtils.toString(new FileReader("album.json"));
		// 将Json字符串读入内存并转化为tree类型
		JsonNode node = mapper.readTree(originJson);
		
		Iterator<JsonNode> songElement =  node.path("songs").iterator();
		while(songElement.hasNext()) {
			System.out.println(songElement.next().path("rain"));
		}
	}

}
