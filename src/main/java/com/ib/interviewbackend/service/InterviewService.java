package com.ib.interviewbackend.service;

import com.ib.interviewbackend.entity.Interview;
import com.ib.interviewbackend.Repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {
    @Autowired
    private InterviewRepository interviewRepository;

    public Interview scheduleInterview(Interview interview) {
        return interviewRepository.save(interview);
    }
}
