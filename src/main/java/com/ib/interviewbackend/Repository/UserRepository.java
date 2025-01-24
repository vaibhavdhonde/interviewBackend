package com.ib.interviewbackend.Repository;
import com.ib.interviewbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
