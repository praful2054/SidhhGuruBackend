package com.exam.examportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.entities.UserScore;
import com.exam.examportal.services.UserScoreService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserScoreController {
	
	@Autowired
	private UserScoreService userScoreService;
	
	@PostMapping("/addScore")
	public ResponseEntity<UserScore> addScore(@RequestBody UserScore userScore){
		
		UserScore scoreOfUser = userScoreService.addUserScore(userScore);
		
		
		return ResponseEntity.ok(scoreOfUser);
		
	}
	
	@GetMapping("/viewAllScores")
	public ResponseEntity<List<UserScore>> viewAllUsersScore(){
		
		List<UserScore> scoreOfUser = userScoreService.viewAllUsersScore();
		
		
		return ResponseEntity.ok(scoreOfUser);
		
	}
	
	@GetMapping("/score/{username}")
	public ResponseEntity<List<UserScore>> viewUsersScore(@PathVariable("username") String username){
		
		List<UserScore> scoreOfUser = userScoreService.viewUsersScore(username);
		
		
		return ResponseEntity.ok(scoreOfUser);
		
	}

}
