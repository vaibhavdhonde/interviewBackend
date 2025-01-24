package com.ib.interviewbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;

@Entity
public class Interview {

    @Id
    @GeneratedValue(generator = "custom-sequence-generator")
    @GenericGenerator(name = "custom-sequence-generator", strategy = "com.ib.interviewbackend.generator.CustomSequenceGenerator")

    private String rh01;

    private String candidateEmail;
    private String candidateName;
    private String recruiterEmail;
    private String recruiterName;
    private String interviewType;
    private String stageOfInterview;
    private LocalDateTime interviewDate;
    private String description;
    private String googleMeetLink;
    private String phoneNumber;
    private String inOfficeDescription;

    // Getters and Setters
    public String getRh01() {
        return rh01;
    }

    public void setRh01(String rh01) {
        this.rh01 = rh01;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    public String getRecruiterName() {
        return recruiterName;
    }

    public void setRecruiterName(String recruiterName) {
        this.recruiterName = recruiterName;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String getStageOfInterview() {
        return stageOfInterview;
    }

    public void setStageOfInterview(String stageOfInterview) {
        this.stageOfInterview = stageOfInterview;
    }

    public LocalDateTime getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDateTime interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoogleMeetLink() {
        return googleMeetLink;
    }

    public void setGoogleMeetLink(String googleMeetLink) {
        this.googleMeetLink = googleMeetLink;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInOfficeDescription() {
        return inOfficeDescription;
    }

    public void setInOfficeDescription(String inOfficeDescription) {
        this.inOfficeDescription = inOfficeDescription;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "rh01='" + rh01 + '\'' +
                ", candidateEmail='" + candidateEmail + '\'' +
                ", candidateName='" + candidateName + '\'' +
                ", recruiterEmail='" + recruiterEmail + '\'' +
                ", recruiterName='" + recruiterName + '\'' +
                ", interviewType='" + interviewType + '\'' +
                ", stageOfInterview='" + stageOfInterview + '\'' +
                ", interviewDate=" + interviewDate +
                ", description='" + description + '\'' +
                ", googleMeetLink='" + googleMeetLink + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", inOfficeDescription='" + inOfficeDescription + '\'' +
                '}';
    }
}
