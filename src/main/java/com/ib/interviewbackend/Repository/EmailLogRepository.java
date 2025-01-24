package com.ib.interviewbackend.Repository;

import com.ib.interviewbackend.entity.EmailLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailLogRepository extends JpaRepository<EmailLog, Long> {}
