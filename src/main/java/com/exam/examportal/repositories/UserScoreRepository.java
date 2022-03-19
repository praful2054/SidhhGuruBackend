package com.exam.examportal.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exam.examportal.entities.UserScore;


@Repository
public interface UserScoreRepository extends MongoRepository<UserScore, Long>{

	List<UserScore> findByUsername(String username);

}
