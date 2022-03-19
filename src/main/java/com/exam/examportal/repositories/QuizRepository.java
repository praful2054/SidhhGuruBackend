package com.exam.examportal.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exam.examportal.entities.exam.Category;
import com.exam.examportal.entities.exam.Quiz;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, Long> {

	List<Quiz> findByCategory(Category c);
	
	List<Quiz> findByActive(Boolean b);
	List<Quiz> findByCategoryAndActive(Category c,Boolean b);

}