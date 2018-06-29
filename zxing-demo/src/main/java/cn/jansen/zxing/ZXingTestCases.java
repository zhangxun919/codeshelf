package cn.jansen.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

// 生成及解析简单的二维码
public class ZXingTestCases {
	
	// 定义输出二维码图片的大小
	private Integer width = 300;
	private Integer height = 300;
	// 定义输出图片的格式
	private String format = "png";
	// 定义二维码所代表的内容
	// 如果想将网址作为二维码的内容，实现扫码直接打开网址，则必须给网址加上http://
	private String content = "Zxing生成二维码实例";
	private Map hints = new HashMap();
	
	@Test
	public void testCreateQRCode() throws WriterException, IOException {
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		BitMatrix bm = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
		Path path = new File("hello.png").toPath();
		MatrixToImageWriter.writeToPath(bm, format, path);
		System.out.println("生成二维码结束！");
	}
	
	@Test
	public void testParseQRCode() throws IOException, NotFoundException{
		MultiFormatReader mr = new MultiFormatReader();
		File file = new File("hello.png");
		BufferedImage bi = ImageIO.read(file);
		BinaryBitmap bb = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bi)));
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		Result res = mr.decode(bb,hints);
		System.out.println("解析二维码的结果为：" + res.toString());
		System.out.println("解析二维码的类型为：" + res.getBarcodeFormat());
		System.out.println("解析二维码的文本为：" + res.getText());
	}

}
