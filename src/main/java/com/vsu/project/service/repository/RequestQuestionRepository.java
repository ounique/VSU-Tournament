package com.vsu.project.service.repository;

import com.vsu.project.service.entity.RequestQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestQuestionRepository extends JpaRepository<RequestQuestion,Long> {
}
