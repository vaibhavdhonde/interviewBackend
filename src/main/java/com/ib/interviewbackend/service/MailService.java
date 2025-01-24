package com.ib.interviewbackend.service;

import com.ib.interviewbackend.entity.EmailLog;
import com.ib.interviewbackend.Repository.EmailLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailLogRepository emailLogRepository;

    public void sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        } catch (Exception e) {
            logger.error("Failed to send email", e);
        }
    }

    public void logEmail(String from, String candidateEmail, String recruiterEmail, String status) {
        EmailLog emailLog = new EmailLog();
        emailLog.setFromEmail(from);
        emailLog.setCandidateEmail(candidateEmail);
        emailLog.setRecruiterEmail(recruiterEmail);
        emailLog.setStatus(status);
        emailLog.setTimestamp(LocalDateTime.now());
        emailLogRepository.save(emailLog);
    }
}

