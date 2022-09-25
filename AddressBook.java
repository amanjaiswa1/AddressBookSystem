package com.assignments.day9.AddressBookSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contacts {
	String firstName, lastName, city, state, email, phoneNumber, zipCode;

	public Contacts(String firstName, String lastName, String phoneNumber, String email, String city, String state,
			String zipCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "First Name : '" + firstName + "', Last Name : '" + lastName + "', Phone Number : '" + phoneNumber
				+ "', email ID : '" + email + "', City : '" + city + "', State : '" + state + "', Zipcode : '" + zipCode
				+ "'";
	}
}

public class AddressBook {
	static Scanner sc = new Scanner(System.in);
	static List<Contacts> contactsList;
	private static String firstName, lastName, city, state, email, phoneNumber, zipCode;

	private static void newContact() {
		System.out.print("Enter First Name : ");
		firstName = sc.next();
		System.out.print("Enter Last Name : ");
		lastName = sc.next();
		System.out.print("Enter Phone : ");
		phoneNumber = sc.next();
		System.out.print("Enter Email : ");
		email = sc.next();
		System.out.print("Enter City : ");
		city = sc.next();
		System.out.print("Enter State : ");
		state = sc.next();
		System.out.print("Enter Zip : ");
		zipCode = sc.next();
	}

	public static void main(String[] args) {
		System.out.println(":: Welcome to Address Book Program ::\n");
		contactsList = new ArrayList<>();
		System.out.println(": Add new Contact :\n");
		newContact();
		Contacts contacts = new Contacts(firstName, lastName, phoneNumber, email, city, state, zipCode);
		contactsList.add(contacts);
		System.out.println("\n: Contact Added to the Address Book :\n");
		System.out.println(contacts);
	}
}
