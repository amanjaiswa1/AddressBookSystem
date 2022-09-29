package com.assignments.day9.AddressBookSystem;

import java.util.*;
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

	// Setter for user inputs.
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	public void setPhone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipcode(String zipCode) {
		this.zipCode = zipCode;
	}

	// Displays the contacts of address book.
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

	public static void main(String[] args) {
		System.out.println(":: Welcome to Address Book Program ::");
		contactsList = new ArrayList<>();
		showMenu();
	}

	// Menu to perform relevant tasks.
	private static void showMenu() {
		System.out.println("\n: Please Select The Option : ");
		System.out.println("1. Show All Contacts.");
		System.out.println("2. Add A New Contact.");
		System.out.println("3. Edit A Contact.");
		System.out.println("4. Delete A Contact.");
		System.out.println("5. Exit");
		int selection = sc.nextInt();
		switch (selection) {
		case 1:
			showContact();
		case 2:
			addContact();
		case 3:
			updateContact();
		case 4:
			deleteContact();
		case 5:
			System.exit(0);
		default:
			showMenu();
		}
	}

	// Shows the stored contacts in address book.
	private static void showContact() {
		System.out.println("\n: Contacts :");
		int count = 1;
		for (Contacts contacts : contactsList) {
			System.out.println("Contact Number " + count + ": " + contacts + "\n");
			count++;
		}
		showMenu();
	}

	// Adds contact in address book.
	private static void addContact() {
		System.out.println("\n: Add A New Contact :");
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

		boolean existing = false;
		for (Contacts contacts : contactsList) {
			existing = contacts.firstName.equals(firstName) && contacts.lastName.equals(lastName);
		}
		if (!existing) {
			Contacts contacts = new Contacts(firstName, lastName, phoneNumber, email, city, state, zipCode);
			contactsList.add(contacts);
			System.out.println("\n: Contact Added to the Address Book :");
			System.out.println(contacts);
		} else {
			System.out.println("\n: This Name already exists in the Address Book :");
		}
		showMenu();
	}

	// Edits the existing contacts in address book by name of the person.
	private static void updateContact() {
		System.out.println("\nEnter the Name of the Person to Update the contact details: ");
		String name = sc.next();
		for (Contacts contacts : contactsList) {
			if (contacts.firstName.equals(name)) {
				System.out.println("\n: Add new Contact :\n");
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
				contacts.setFirstname(firstName);
				contacts.setLastname(lastName);
				contacts.setPhone(phoneNumber);
				contacts.setEmail(email);
				contacts.setCity(city);
				contacts.setState(state);
				contacts.setZipcode(zipCode);
				System.out.println("\n: Contact Updated :\n");
			}
		}
		showMenu();
	}

	// Delete any existing contact from address book ny person name.
	private static void deleteContact() {
		System.out.println("Enter the Name to Delete the contact details: ");
		String name = sc.next();
		for (Contacts contacts : contactsList) {
			if (contacts.firstName.equals(name)) {
				contactsList.remove(contacts);
				System.out.println("Deleted from the Address Book.");
				showMenu();
			}
		}
	}
}
