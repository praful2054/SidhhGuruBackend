package com.exam.examportal.dto;

public class MessageResponse {
	private String username;
	private String message;

	public MessageResponse(String username,String message) {
		this.username = username;
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
