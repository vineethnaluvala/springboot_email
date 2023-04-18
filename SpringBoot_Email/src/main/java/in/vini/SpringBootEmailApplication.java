package in.vini;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import in.vini.service.EmailSenderService;

@SpringBootApplication
public class SpringBootEmailApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		emailSenderService.sendMailWithAttachment("xxxxxxx@gmail.com",
				"Hi , please find my resume as an attachment", "Java Developer",
				"" + "D:\\vini-personal\\documents\\resume\\CV(Vineeth).pdf");

	}

}
