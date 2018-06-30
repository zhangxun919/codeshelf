package cn.jansen.thumbnailator;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import net.coobird.thumbnailator.Thumbnails;

public class thumbnailatorTest {

	// 指定缩略图的大小
	public static final int THUMBWIDTH = 100;
	public static final int THUMBHEIGHT = 100;
	
	@Test
	public void testOriginToThumb() throws IOException {
		File origin = new File("github.jpg");
		File dest = new File("thumb.jpg");
		Thumbnails.of(origin).size(THUMBWIDTH, THUMBHEIGHT).toFile(dest);
		System.out.println("生成缩略图结束！");
	}
	
}
