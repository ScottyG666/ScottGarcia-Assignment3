package com.Bootcamp.Assignment3;
public class UserService {
	
	public User createUser(String[] inputs) {
		return new User(inputs);
	}
	
	public String[] parseString(String input) {
		return input.split(",");
	}
	
	public User setProperties(User Obj) {
		String[] objProperties = new String[3];
		objProperties[0] = Obj.username;
		objProperties[1] = Obj.password;
		objProperties[2] = Obj.user;
		
		return new User(objProperties);
		
	}
	
}
