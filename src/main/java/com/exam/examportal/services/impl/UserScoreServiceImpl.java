package com.exam.examportal.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.entities.UserScore;
import com.exam.examportal.repositories.UserScoreRepository;
import com.exam.examportal.services.UserScoreService;


@Service
public class UserScoreServiceImpl implements UserScoreService{
	
	@Autowired
	private UserScoreRepository userScoreRepository;

	@Override
	public UserScore addUserScore(UserScore userScore) {
		userScore.setAttemptedDate(LocalDate.now());
		return userScoreRepository.save(userScore);
	}

	@Override
	public List<UserScore> viewAllUsersScore() {
		List<UserScore> listOfUsersScore = userScoreRepository.findAll();
		return listOfUsersScore;
	}

	@Override
	public List<UserScore> viewUsersScore(String username) {
		List<UserScore> listOfUserScore = userScoreRepository.findByUsername(username);
		return listOfUserScore;
	}

}
