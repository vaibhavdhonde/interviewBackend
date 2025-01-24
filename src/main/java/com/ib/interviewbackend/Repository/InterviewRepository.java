package com.ib.interviewbackend.Repository;

import com.ib.interviewbackend.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, String> {}
