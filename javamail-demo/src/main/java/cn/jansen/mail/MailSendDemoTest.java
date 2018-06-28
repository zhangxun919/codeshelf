package cn.jansen.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.junit.Before;
import org.junit.Test;

public class MailSendDemoTest {
	
	private Properties properties = null;
	private Session mailSession = null;
	private MimeMessage mailMessage = null;
	
	@Before
	public void before() {
	}
	
	@Test
	public void testSendLocalMail() throws MessagingException, FileNotFoundException {
		properties = new Properties();
		// 开启调试模式，打印详细信息
		properties.setProperty("mail.debug", "true");
		// 登录SMTP服务器需要身份验证
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "25");
		properties.setProperty("mail.transport.protocol", "smtp");
		// 设置smtp服务器主机名
		properties.setProperty("mail.host", "smtp.163.com");
		
		mailSession = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("from-address@163.com","your-password");
			}
		});
		
		mailMessage = new MimeMessage(mailSession,  new FileInputStream(new File("media.eml")));
		Transport.send(mailMessage);
	}
	
	
}
