package com.assignments.day9.AddressBookSystem;

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

	public void show() {
		System.out.println("First Name : " + firstName);
		System.out.println("Last Name  : " + lastName);
		System.out.println("Phone Number : " + phoneNumber);
		System.out.println("Email-ID : " + email);
		System.out.println("City  : " + city);
		System.out.println("State : " + state);
		System.out.println("Zip Code : " + zipCode);
	}
}

public class AddressBook {
	public static void main(String[] args) {
		System.out.println(":: Welcome to Address Book Program ::\n");
		Contacts contacts = new Contacts("Tekesh", "Kumar", "9996663333", "tekeshk@gmail.com", "Bhilai", "Chhattisgarh","490020");
		contacts.show();
	}
}
