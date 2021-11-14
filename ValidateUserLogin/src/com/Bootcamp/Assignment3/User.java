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
	
	public void getProperties() {
		System.out.println(this.username + "\n" + this.password + "\n" + this.user);
	}
}
