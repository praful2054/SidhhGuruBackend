package com.exam.examportal.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.entities.exam.Category;
import com.exam.examportal.entities.exam.Quiz;
import com.exam.examportal.repositories.QuizRepository;
import com.exam.examportal.services.QuizService;


@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getquizzes() {
		// TODO Auto-generated method stub
		return new HashSet<>(quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return quizRepository.findById(quizId).get();
	}

	@Override
	public void delete(Long quizId) {
		quizRepository.deleteById(quizId);
		
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category c) {
		
		return quizRepository.findByCategory(c);
	}

	@Override
	public List<Quiz> getActiveQuizzess() {
		// TODO Auto-generated method stub
		return quizRepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzessOfCategory(Category c) {
		// TODO Auto-generated method stub
		return quizRepository.findByCategoryAndActive(c, true);
	}

}
