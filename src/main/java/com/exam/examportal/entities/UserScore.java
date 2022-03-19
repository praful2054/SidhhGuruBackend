package com.exam.examportal.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class UserScore {
	
	@Id
	private long id;
	private String username;
	private String quizName;
	private long marksGot;
	private long totalMarks;
	private LocalDate attemptedDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	
	
	public long getMarksGot() {
		return marksGot;
	}
	public void setMarksGot(long marksGot) {
		this.marksGot = marksGot;
	}
	public long getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(long totalMarks) {
		this.totalMarks = totalMarks;
	}
	public LocalDate getAttemptedDate() {
		return attemptedDate;
	}
	public void setAttemptedDate(LocalDate attemptedDate) {
		this.attemptedDate = attemptedDate;
	}
	
}
