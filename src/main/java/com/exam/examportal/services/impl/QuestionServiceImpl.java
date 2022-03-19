package com.exam.examportal.services.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.entities.exam.Question;
import com.exam.examportal.entities.exam.Quiz;
import com.exam.examportal.repositories.QuestionRepository;
import com.exam.examportal.repositories.QuizRepository;
import com.exam.examportal.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuizRepository quizRespository;

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizRespository.findById(question.getQuiz().getQid());
		question.setQuiz(quiz.get());
		return questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		Question one = questionRepository.findById(question.getQuesId()).get();
		one.setAnswer(question.getAnswer());
		one.setContent(question.getContent());
		one.setGivenAnswer(question.getGivenAnswer());
		one.setOption1(question.getOption1());
		one.setOption2(question.getOption2());
		one.setOption3(question.getOption3());
		one.setOption4(question.getOption4());
		return questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		// TODO Auto-generated method stub
		return new HashSet<>(questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long quesId) {
		// TODO Auto-generated method stub
		return questionRepository.findById(quesId).get();
	}

	@Override
	public void deleteQuestion(Long quesId) {
		questionRepository.deleteById(quesId);
		
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return questionRepository.findByQuiz(quiz);
	}

}
