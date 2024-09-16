package com.example.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor@ToString
public class LoginReturn {
	public LoginReturn(int id, boolean isSuccessfull, String error) {
		super();
		this.id = id;
		this.isSuccessfull = isSuccessfull;
		this.error = error;
	}
	int id;
	boolean isSuccessfull;
	String error;
	
	
}
