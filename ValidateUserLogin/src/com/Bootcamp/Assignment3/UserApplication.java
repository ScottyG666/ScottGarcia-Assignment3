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
		
		
		//this variable sets the amount of times a user may try to log in before it terminates if the 
		//username password combination doesn't match
		final int ALLOWED_LOG_IN_ATTEMPTS = 5;
		boolean matching = false;
		User CurrentUser = new User();
		String allegedUsername = new String();
		String allegedPassword = new String();
		Scanner scanner = new Scanner(System.in);
		
		try {
				//allows only 5 Attempts to log in
			for (int j = 0; j < ALLOWED_LOG_IN_ATTEMPTS; j++) {
				
				if (!matching) {
					
					System.out.println("Enter your email: ");
					allegedUsername = scanner.nextLine().toLowerCase();
					System.out.println("Enter you password: ");
					allegedPassword = scanner.nextLine();
				
			}
				for (User user : Users) {

					if (allegedUsername.equals(allegedUsername) && allegedPassword.equals(allegedPassword)) {
						j = ALLOWED_LOG_IN_ATTEMPTS;
						System.out.println(CurrentUser);
						CurrentUser = user;
						System.out.println(CurrentUser);
				}
			}
				
			
				
		}
		
	} finally {
		scanner.close();
	}
	}

}
