package com.bookstore.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;
@Configuration
@RequiredArgsConstructor
public class MailConfig {
    @Value( "${spring.mail.host}" )
    private final String HOST;
    @Value( "${spring.mail.username}" )
    private final String USER_NAME;
    @Value( "${spring.mail.password}" )
    private final String PASSWORD;
    @Value( "${spring.mail.properties.mail.smtp.socketFactory.port}" )
    private final String PORT;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(HOST);
        mailSender.setPort(Integer.parseInt(PORT)); // Your mail server port
        mailSender.setUsername(USER_NAME);
        mailSender.setPassword(PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
