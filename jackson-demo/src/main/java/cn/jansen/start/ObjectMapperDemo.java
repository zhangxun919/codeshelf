package cn.jansen.start;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjectMapperDemo {
	
	private ObjectMapper mapper = null;
	
	@Before
	public void before() {
		mapper = new ObjectMapper();
	}
	
	@Test
	public void testConvertBeanToJsonWithObjectMapper() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		Album silentSpring = new Album();
		// 字符串
		silentSpring.setTitle("寂静的春天");
		// 数组array
		silentSpring.setLinks(new String[] {"www.silentspring.com","www.silentspring.cn","www.silentspring.top"});
		
		// list和array转换为Json后表现形式都是数组
		List<String> songList = new ArrayList<String>();
		songList.add("冰雨");
		songList.add("等风来");
		songList.add("春之歌");
		silentSpring.setSongs(songList);
		
		// 对象object
		Artist jansen = new Artist();
		jansen.setName("Jansen");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		jansen.setBirthdate(sdf.parse("1994-10-26"));
		silentSpring.setArtist(jansen);
		
		// map转换后的格式和object相同
		Map<String,String> toolMap = new HashMap<String,String>();
		toolMap.put("tool1", "钢琴");
		toolMap.put("tool2", "小提琴");
		toolMap.put("tool3", "手风琴");
		silentSpring.setTools(toolMap);
		
		// 让控制台输出的Json数据美观
		mapper.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
		// map存放的数据是无序的，因此输出时会很乱，下面这句是让map的输出按照key排序
		mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, Boolean.TRUE);
		// 让日期按照下面设定的格式展示
		mapper.setDateFormat(sdf);
		// 下面设置可以让Json中没有值的不展示
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		mapper.writeValue(System.out, silentSpring);
	}

}
