package com.exam.examportal.services;

import java.util.List;

import com.exam.examportal.entities.UserScore;

public interface UserScoreService {

	UserScore addUserScore(UserScore userScore);

	List<UserScore> viewAllUsersScore();

	List<UserScore> viewUsersScore(String username);

}
