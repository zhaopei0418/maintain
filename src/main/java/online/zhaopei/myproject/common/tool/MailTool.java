package online.zhaopei.myproject.common.tool;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public final class MailTool {

	public static void sendMail(JavaMailSender mailSender, String from, String to, String subject, String text) {
		try {
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(from);// 发送者.
			message.setTo(to);// 接收者.
			message.setSubject(subject);// 邮件主题.
			message.setText(text);// 邮件内容.

			mailSender.send(message);// 发送邮件
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendDefaultMail(JavaMailSender mailSender, String subject, String text) {
		sendMail(mailSender, "sender000@126.com", "122044856@qq.com", subject, text);
	}
}
