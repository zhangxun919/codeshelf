package cn.jansen.mail;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Before;
import org.junit.Test;

/*
 * 使用JavaMail有几个重要的类需要记住：
 * 1.MimeMessage表示整个一封邮件
 * 2.MimeMultiPart表示由多个单独mime消息组成的组合mime消息
 * 3.MimeBodyPart表示邮件中的一个单独mime消息
 * 它们之间的关系是多个MimeBodyPart组成一个MimeMultiPart，多个MimeMultiPart组成一个MimeMessage
 */
public class MailGenerateDemoTest {
	private static final String FROM_MAIL_ADDRESS = "from-address@163.com";
	private static final String TO_MAIL_ADDRESS="to-address@qq.com";
	private static final String MAIL_SUBJECT="JavaMail";
	private static final String MAIL_CONTENT="这是一封使用JavaMail发送的邮件。";
	
	private Session mailSession = null;
	private MimeMessage mailMessage = null;
	
	@Before
	public void before() throws AddressException, MessagingException {
		mailSession = Session.getDefaultInstance(new Properties());
		mailMessage = new MimeMessage(mailSession);
		mailMessage.setFrom(new InternetAddress(FROM_MAIL_ADDRESS));
		mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(TO_MAIL_ADDRESS));
		mailMessage.setSubject(MAIL_SUBJECT);
	}
	
	@Test
	public void testPlainTextMail() throws MessagingException, FileNotFoundException, IOException {
		MimeBodyPart content = new MimeBodyPart();
		// 指定为utf8防止中文乱码
		content.setContent(MAIL_CONTENT, "text/html;charset=UTF-8");
		MimeMultipart part = new MimeMultipart();
		part.addBodyPart(content);
		part.setSubType("mixed");
		mailMessage.setContent(part);
		mailMessage.saveChanges();
		mailMessage.writeTo(new FileOutputStream("text.eml"));
		System.out.println("生成文本邮件结束");
	}
	
	@Test
	public void testMediaMail() throws MessagingException, FileNotFoundException, IOException {
		String picRef = "<br/><a href='https://github.com'><img src='cid:githubjpg'/></a>";
		// 正文文字
		MimeBodyPart content = new MimeBodyPart();
		// 指定正文格式为utf8防止中文乱码，其中还引用了图片
		content.setContent(MAIL_CONTENT + picRef, "text/html;charset=UTF-8");
		
		// 正文图片
		MimeBodyPart pic = new MimeBodyPart();
		DataHandler handler = new DataHandler(new FileDataSource("github.jpg"));
		pic.setDataHandler(handler);
		// 设置图片的id，在正文部分引用它
		pic.setContentID("githubjpg");
		pic.setDisposition(MimeBodyPart.INLINE);
		
		// 附件
		MimeBodyPart attach = new MimeBodyPart();
		DataHandler handler2 = new DataHandler(new FileDataSource("github.txt"));
		attach.setDataHandler(handler2);
		// 设置附件名称的同时防止其乱码
		attach.setFileName(MimeUtility.encodeText("GitHub地址附件.txt"));
		
		// 描述各个MimeBodyPart之间的关系，当一封邮件中MimeBodyPart有两个及以上就必须描述它们之间的关系
		// 关系一般有三种：mixed-无关系；related-引用关系；alternative-二者选其一
		
		// 正文和图片是related关系
		MimeMultipart part1 = new MimeMultipart();
		part1.addBodyPart(content);
		part1.addBodyPart(pic);
		part1.setSubType("related");
		
		// 构造一个普通的MimeBodyPart用来承载上面正文和图片的组合
		MimeBodyPart contentAndPic = new MimeBodyPart();
		contentAndPic.setContent(part1);
		
		// 上面的组合信息和附件是mixed关系
		MimeMultipart part2 = new MimeMultipart();
		part2.addBodyPart(contentAndPic);
		part2.addBodyPart(attach);
		part2.setSubType("mixed");
		
		// 最后将大的MimeMultipart放到mailMessage中
		mailMessage.setContent(part2);
		mailMessage.saveChanges();
		
		mailMessage.writeTo(new FileOutputStream("media.eml"));
		System.out.println("生成多媒体邮件结束");
	}

}
