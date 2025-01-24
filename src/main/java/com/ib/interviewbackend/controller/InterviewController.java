package com.ib.interviewbackend.controller;

import com.ib.interviewbackend.entity.Interview;
import com.ib.interviewbackend.entity.ResponseMessage;
import com.ib.interviewbackend.service.InterviewService;
import com.ib.interviewbackend.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/interviews")
@CrossOrigin(origins = "http://localhost:4200")
public class InterviewController {
    private static final Logger logger = LoggerFactory.getLogger(InterviewController.class);

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private MailService mailService;

    @PostMapping("/schedule")
    public ResponseEntity<ResponseMessage> scheduleInterview(@RequestBody Interview interview) {
        Interview scheduledInterview = interviewService.scheduleInterview(interview);

        // Build email bodies based on interview type
        String candidateEmailBody = buildCandidateEmailBody(scheduledInterview);
        String recruiterEmailBody = buildRecruiterEmailBody(scheduledInterview);

        CompletableFuture.runAsync(() -> {
            try {
                mailService.sendEmail(scheduledInterview.getCandidateEmail(), "Interview Scheduled", candidateEmailBody);
                mailService.sendEmail(scheduledInterview.getRecruiterEmail(), "Interview Scheduled", recruiterEmailBody);
                mailService.logEmail("vaibhavdhonde12345@gmail.com", scheduledInterview.getCandidateEmail(), scheduledInterview.getRecruiterEmail(), scheduledInterview.getStageOfInterview());
            } catch (Exception e) {
                logger.error("Failed to send emails or log email", e);
            }
        });

        // Return a ResponseEntity with the success message in a structured JSON format
        ResponseMessage responseMessage = new ResponseMessage("Interview scheduled and emails sent successfully!");
        return ResponseEntity.ok(responseMessage);
    }

    private String buildCandidateEmailBody(Interview interview) {
        StringBuilder emailBody = new StringBuilder("Dear " + interview.getCandidateName() + ",\n\nYour interview is scheduled on " +
                interview.getInterviewDate() +
                ".\nInterview Type: " + interview.getInterviewType() +
                "\nStage of Interview: " + interview.getStageOfInterview() +
                "\nDescription: " + interview.getDescription());

        if ("ONLINE MEET".equals(interview.getInterviewType())) {
            emailBody.append("\nGoogle Meet Link: ").append(interview.getGoogleMeetLink());
        } else if ("TELEPHONIC".equals(interview.getInterviewType())) {
            emailBody.append("\nPhone Number: ").append(interview.getPhoneNumber());
        } else if ("IN OFFICE".equals(interview.getInterviewType())) {
            emailBody.append("\nIn Office Description: ").append(interview.getInOfficeDescription());
        }

        emailBody.append("\n\nBest regards,\nRecruitment Team");
        return emailBody.toString();
    }

    private String buildRecruiterEmailBody(Interview interview) {
        StringBuilder emailBody = new StringBuilder("Dear " + interview.getRecruiterName() + ",\n\nAn interview is scheduled on " +
                interview.getInterviewDate() +
                ".\nInterview Type: " + interview.getInterviewType() +
                "\nStage of Interview: " + interview.getStageOfInterview() +
                "\nDescription: " + interview.getDescription());

        if ("ONLINE MEET".equals(interview.getInterviewType())) {
            emailBody.append("\nGoogle Meet Link: ").append(interview.getGoogleMeetLink());
        } else if ("TELEPHONIC".equals(interview.getInterviewType())) {
            emailBody.append("\nPhone Number: ").append(interview.getPhoneNumber());
        } else if ("IN OFFICE".equals(interview.getInterviewType())) {
            emailBody.append("\nIn Office Description: ").append(interview.getInOfficeDescription());
        }

        emailBody.append("\n\nBest regards,\nRecruitment Team");
        return emailBody.toString();
    }
}
