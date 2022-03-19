package com.exam.examportal.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exam.examportal.entities.exam.Question;
import com.exam.examportal.entities.exam.Quiz;


@Repository
public interface QuestionRepository extends MongoRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
