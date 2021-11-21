package com.Bootcamp.Assignment3;

public class UserService {
	//Method that creates a new User when the argument passed is an Array of Strings
	public User createUser(String[] inputs) {
		return new User(inputs);
	}
	//method that creates a new User when the argument passed is an already instantiated User Object
	public User createUser(User obj) {
		return new User(obj);
	}
	//this method breaks apart the line received from the CSV file and turns it into a String[]
	public String[] parseString(String input) {
		return input.split(",");
	}
}
