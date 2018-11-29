package javaMailTest;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

	public static void main(String[] args) {
		//收件人电子邮箱
		String to = "1040356809@qq.com";
		
		//发件人电子邮箱
		String from = "2565166373@qq.com";
		
		String host = "localhost";
		
		//获取系统属性
		Properties properties = System.getProperties();
		
		//设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		
		//获取默认session对象 
		Session session = Session.getDefaultInstance(properties);
		
		try {
			//创建默认的MimeMessage 对象 
			MimeMessage message = new MimeMessage(session);
			
			//Set From 头部字段
			message.setFrom(new InternetAddress(from));
			
			//Set To 头部字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//Set Subject 头部字段
			message.setSubject("This is the Subject Line!");
			
			//设置消息体
			message.setText("This is actual message");
			
			//发送消息
			Transport.send(message);
			System.out.println("send message successfully...");
	
		}catch(MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
