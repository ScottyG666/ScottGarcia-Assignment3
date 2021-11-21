package com.Bootcamp.Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserApplication {

	public static void main(String[] args) {
		
		//Instantiates fileReader in the global scope so i can be closed in the finally block
		BufferedReader fileReader = null;
		
		//UserService for parsing string, creating a user, validating the inputed username and 
		//password against the username/password combinations in the User[]
		UserService US = new UserService();
		
		//This number represents how large the User[] will be
		final int LENGTH_OF_ARRAY = 4;
		
		//User Array for storing the 4 users in our data.txt sheet
		User[] Users = new User[LENGTH_OF_ARRAY];
		
		
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
			System.out.println("There was an I/O Exception");
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("There was an I/O Exception");

			}
		}
		//This is the beginning of the User validation 
		
		//scanner declared globally, so i can close it just before the application terminates
		Scanner scanner = new Scanner(System.in);
		/*this int defines how many times a user may attempt a username/password combination before
		they are "Locked out"
		*/
		final int 	NUMBER_OF_LOGIN_ATTEMPTS = 5;
		
		//This is a placeholder for Assigning who the current user is if they pass the Username/Password validation
		User CurrentUser = null;
		//variable changes if the user has input a username/password combination that matched with the one from CSV
		boolean credentialsAreValid = false;
		//loops for 5 times in this iteration, or the amount of NUMBER_OF_LOGIN_ATTEMPTS is reached
		for( int j = 0; j < NUMBER_OF_LOGIN_ATTEMPTS; j++) {
			if (credentialsAreValid) {
				j = NUMBER_OF_LOGIN_ATTEMPTS;
				break;
			} else if (!credentialsAreValid) {
				
				System.out.println("Enter your email: ");
				String allegedUsername = scanner.nextLine().toLowerCase();
				System.out.println("Enter you password: ");
				String allegedPassword = scanner.nextLine();
				
				for (User user: Users) {
					if (user.username.equals(allegedUsername) && user.password.equals(allegedPassword)) {
						credentialsAreValid = true;
						CurrentUser = user;
						break;
					}
				}
			}
		}
		

		if(!credentialsAreValid) {
			System.out.println("Now you locked out homie.");
		}
		
		
		if (CurrentUser != null) {
			CurrentUser.greet();
		}
			
		
		scanner.close();
		
	}

}
