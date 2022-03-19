package com.exam.examportal.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.entities.exam.Question;
import com.exam.examportal.entities.exam.Quiz;
import com.exam.examportal.services.QuestionService;
import com.exam.examportal.services.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		
		return ResponseEntity.ok(questionService.addQuestion(question));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable("id") String id, @RequestBody Question question){
		question.setQuesId(Long.parseLong(id));
		
		return ResponseEntity.ok(questionService.updateQuestion(question));
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable Long quizId){
		
		Quiz quiz = quizService.getQuiz(quizId);
		
		
        List<Question> list = new ArrayList<>();
  
        
        for (Question ques : quiz.getQuestions())
            list.add(ques);
 
		
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		list.forEach((q)->{
			q.setAnswer("");
		});
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
		
	}
	@GetMapping("/quiz/all/{quizId}")
	public ResponseEntity<?> getaLLQuestionOfQuiz(@PathVariable Long quizId){
		
		Quiz quiz = quizService.getQuiz(quizId);
		@SuppressWarnings("unchecked")
		Set<Question> list =  quiz.getQuestions();
		
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping("/{quesId}")
	public ResponseEntity<Question> getQuestion(@PathVariable Long quesId){
		
		return ResponseEntity.ok(questionService.getQuestion(quesId));
	}
	
	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable Long quesId){
		
		questionService.deleteQuestion(quesId);	
	}
	
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
		double marksGot=0;
		int correctAnswers =0;
		int attempted =0;
		for(Question q :questions) {
			Question question = questionService.getQuestion(q.getQuesId());
			if(question.getAnswer().equalsIgnoreCase(q.getGivenAnswer())) {
				correctAnswers++;
				
				double marksSingle = (Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()))/questions.size();
				marksGot += marksSingle;
			}
			if(q.getGivenAnswer()!=null) {
				attempted++;
			}
		}
		Map<String,Object> map = Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);
		return ResponseEntity.ok(map);
	}

}
