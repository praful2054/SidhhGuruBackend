package com.exam.examportal.services;

import java.util.Set;

import com.exam.examportal.entities.exam.Question;
import com.exam.examportal.entities.exam.Quiz;

public interface QuestionService {
	
	
	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions();
	
	public Question getQuestion(Long quesId);
	
	public void deleteQuestion(Long quesId);
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);

}
