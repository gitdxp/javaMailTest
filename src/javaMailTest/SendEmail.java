package javaMailTest;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

	public static void main(String[] args) {
		//�ռ��˵�������
		String to = "1040356809@qq.com";
		
		//�����˵�������
		String from = "2565166373@qq.com";
		
		String host = "localhost";
		
		//��ȡϵͳ����
		Properties properties = System.getProperties();
		
		//�����ʼ�������
		properties.setProperty("mail.smtp.host", host);
		
		//��ȡĬ��session���� 
		Session session = Session.getDefaultInstance(properties);
		
		try {
			//����Ĭ�ϵ�MimeMessage ���� 
			MimeMessage message = new MimeMessage(session);
			
			//Set From ͷ���ֶ�
			message.setFrom(new InternetAddress(from));
			
			//Set To ͷ���ֶ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//Set Subject ͷ���ֶ�
			message.setSubject("This is the Subject Line!");
			
			//������Ϣ��
			message.setText("This is actual message");
			
			//������Ϣ
			Transport.send(message);
			System.out.println("send message successfully...");
	
		}catch(MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
