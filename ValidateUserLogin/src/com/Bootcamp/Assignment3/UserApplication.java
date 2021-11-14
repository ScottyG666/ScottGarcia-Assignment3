package com.Bootcamp.Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserApplication {

	public static void main(String[] args) {
		
		//Buffered reader is an object for reading an external file, instantiated before the try block 
		//so it can be closed inside the finally block
		BufferedReader fileReader = null;
		
		//UserService for parsing string, creating a user, validating the inputed username and 
		//password against the username/password combinations in the User[]
		UserService US = new UserService();
		
		//User Array for storing the 4 users in our data.txt sheet now
		User[] Users = new User[4];
		
		
		//Initial try block to read the file line by line, parse that line into String[]
		//used to create new users, and assign those users to a spot in the Users[]
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			
			String line = "";
			int i = 0;
		
			while ((line = fileReader.readLine()) != null) {
				String[] lines = US.parseString(line);
				
				Users[i] = US.createUser(lines);
				i++;
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Oops, that file wasnt found");
		} catch (IOException e) {
			System.out.println("Yeeeaaaahhhh, there was an I/O Exception");
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Yeeeaaaahhhh, there was an I/O Exception");

			}
		}
		
		for (User user : Users) {
			user.getProperties();
		}
		
		
		//here ill validate the Username/password combination the user input matched a combination 
		// pre-existing in the CSV file provided
		
		//if the username/password combination (not case sensitive for username) of any of the users
		//in the Users[], then that user is assigned as the current user and the program terminates
		
		Scanner scanner = new Scanner(System.in);
		
		User CurrentUser = null;
		
		boolean matchingUser = false;
		
		for( int j = 0; j < 5; j++) {
			if (matchingUser) {
				j = 9000;
				break;
			} else if (!matchingUser) {
				
				System.out.println("Enter your email: ");
				String allegedUsername = scanner.nextLine();
				System.out.println("Enter you password: ");
				String allegedPassword = scanner.nextLine();
				
				for (User user: Users) {
					if (user.username == allegedUsername && user.password == allegedPassword) {
						matchingUser = true;
						CurrentUser = user;
						break;
					}
				}
			}
		}
		
		CurrentUser.getProperties();
	}

}
