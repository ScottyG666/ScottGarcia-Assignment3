package com.Bootcamp.Assignment3;

public class UserService {
	
	public User createUser(String[] inputs) {
		return new User(inputs);
	}
	
	public String[] parseString(String input) {
		return input.split(",");
	}
}
