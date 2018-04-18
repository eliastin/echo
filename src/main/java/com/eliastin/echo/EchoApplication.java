package com.eliastin.echo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("mail")
public class EchoApplication {

	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(EchoApplication.class, args);
	}

	@GetMapping
	@Loggable("发送邮件")
	public ResponseEntity<?> send(String to, String content) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setFrom("cdsfsefon@163.com");
		msg.setSubject("钉钉打卡");
		msg.setText(content);
//		javaMailSender.send(msg);
		return ResponseEntity.ok().build();
	}

	@GetMapping("all")
	public ResponseEntity<?> list() {
		return ResponseEntity.ok().build();
	}
}
