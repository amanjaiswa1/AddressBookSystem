package com.assignments.day9.AddressBookSystem;

public class Contacts {
	String firstName, lastName, city, state, email, phoneNumber, zipCode;

	public Contacts() {

	}

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

	// Getters and Setters methods.
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	// Displays the contacts of address book.
	@Override
	public String toString() {
		return "First Name : '" + firstName + "', Last Name : '" + lastName + "', Phone Number : '" + phoneNumber
				+ "', email ID : '" + email + "', City : '" + city + "', State : '" + state + "', Zipcode : '" + zipCode
				+ "'"+"\n";
	}
}