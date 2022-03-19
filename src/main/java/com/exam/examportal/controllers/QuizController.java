package com.exam.examportal.controllers;

import java.util.List;

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

import com.exam.examportal.entities.exam.Category;
import com.exam.examportal.entities.exam.Quiz;
import com.exam.examportal.services.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {

		return ResponseEntity.ok(quizService.addQuiz(quiz));

	}

	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {

		return ResponseEntity.ok(quizService.updateQuiz(quiz));

	}

	@GetMapping("/")
	public ResponseEntity<?> getAllQuizes() {

		return ResponseEntity.ok(quizService.getquizzes());

	}

	@GetMapping("/{quizId}")
	public ResponseEntity<Quiz> getQuize(@PathVariable Long quizId) {

		return ResponseEntity.ok(quizService.getQuiz(quizId));

	}

	@DeleteMapping("/{quizId}")
	public void deleteQuiz(@PathVariable Long quizId) {

		quizService.delete(quizId);

	}

	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizzessOfCategory(@PathVariable("cid") Long cid) {

		Category c = new Category();
		c.setCid(cid);

		return quizService.getQuizzesOfCategory(c);
	}

	@GetMapping("/active")
	public List<Quiz> getActiveQuizzess() {
		return quizService.getActiveQuizzess();

	}
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizzessOfCategory(@PathVariable("cid") Long cid) {
		Category c = new Category();
		c.setCid(cid);
		return quizService.getActiveQuizzessOfCategory(c);

	}
}

