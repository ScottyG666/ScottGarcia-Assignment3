package com.Bootcamp.Assignment3;

public class User {
	String username;
	String password;
	String user;
	
	User(String[] inputs) {
		this.username = inputs[0];
		this.password = inputs[1];
		this.user = inputs[2];
	}
	
	User (User obj) {
		this.username = obj.username;
		this.password = obj.password;
		this.user = obj.user;
	}
	
	public void greet() {
		System.out.println("Welcome " + this.user);
	}
}
