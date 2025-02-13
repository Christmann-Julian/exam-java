package com.example.exam_java_app.repository;

import com.example.exam_java_app.model.Message;
import com.example.exam_java_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByUser(User user);
}