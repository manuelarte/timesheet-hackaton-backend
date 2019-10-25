package com.sytac.timesheet.service.impl;

import com.sytac.timesheet.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Slf4j
@AllArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender emailSender;

    @Override
    public void send(final String to, final String subject, final String text, final String pathToAttachment) {
        log.info("Sending mail to " + to);
        final MimeMessage message = emailSender.createMimeMessage();

        try {
            final MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            final FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Timesheet.xls", file);

            emailSender.send(message);
        } catch (final MessagingException e) {
            log.error("Unable to send email.", e);
        }
    }
}
