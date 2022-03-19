package com.exam.examportal.services;

import java.util.List;
import java.util.Set;

import com.exam.examportal.entities.exam.Category;
import com.exam.examportal.entities.exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getquizzes();
	public Quiz getQuiz(Long quizId);
	public void delete(Long quizId);
	public List<Quiz> getQuizzesOfCategory(Category c);
	public List<Quiz> getActiveQuizzess();
	public List<Quiz> getActiveQuizzessOfCategory(Category c);


}
