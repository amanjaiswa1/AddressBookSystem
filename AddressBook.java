package com.assignments.day9.AddressBookSystem;

import java.util.*;

public class AddressBook {
	static Scanner scanner = new Scanner(System.in);
	HashMap<String, LinkedList<Contacts>> contactBook = new HashMap<>();

	// Main Method
	public static void main(String[] args) {

		System.out.println(":: Welcome to Address Book Program ::");
		AddressBook addressBook = new AddressBook();
		addressBook.showMenu();
	}

	// Menu Method to show the different operation which can be performed in address book.
	public void showMenu() {
		try {
			while (true) {
				System.out.println("" + "1. Create New Address Book \n" + "2. Continue with existing Address Book \n"
						+ "3. Show All Address Books \n" + "4. Search person by location in all Address Books\n"
						+ "5. Exit");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					System.out.println("\n: Enter a name for Address Book :");
					String newBook = scanner.next();
					LinkedList<Contacts> contactList = new LinkedList<>();

					if (contactBook.containsKey(newBook))
						System.out.println("\n: Book already exists :");
					else
						createContact(contactList, contactBook, newBook);
					break;

				case 2:
					System.out.println(contactBook.keySet());
					System.out.println("Which address book do you want to access?");
					String existingBook = scanner.next();

					if (contactBook.containsKey(existingBook)) {
						contactList = contactBook.get(existingBook);
						createContact(contactList, contactBook, existingBook);
					} else
						System.out.println("\n: Book Not Found :");
					break;

				case 3:
					int serialNo = 1;
					for (String book : contactBook.keySet()) {
						System.out.println(serialNo + ". " + book);
						serialNo++;
					}
					System.out.println("\n" + contactBook);
					break;

				case 4:
					System.out.println("\n: Enter Name of City or State :");
					String nameForLocation = scanner.next();
					searchByLocation(nameForLocation);
					break;

				default:
					System.exit(0);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// createContact Method
	private void createContact(LinkedList<Contacts> contactList, HashMap<String, LinkedList<Contacts>> contactBook,
			String addressBook) {
		try {
			boolean run = true;
			while (run) {
				System.out.println("" + "1. Add a New Contact Detail \n" + "2. Show All Contacts \n"
						+ "3. Update a Contact \n" + "4. Delete a Contact \n" + "5. Exit");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1: {
					LinkedList<Contacts> multiContactInBook = addContact(contactList);
					contactBook.put(addressBook, multiContactInBook);
				}
					break;
				case 2:
					displayContact(contactList);
					break;
				case 3:
					updateContact(contactList);
					break;
				case 4:
					deleteContact(contactList);
					break;
				default:
					run = false;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println(e);
		}
	}

	// addContacts Method
	private LinkedList<Contacts> addContact(LinkedList<Contacts> contactList) {
		try {
			System.out.println("Enter the details \n" + "First Name :");
			String firstName = scanner.next();
			int existingName = searchName(firstName, contactList);
			if (existingName == -1) {
				Contacts contactInfo = new Contacts();
				contactInfo.setFirstName(firstName);

				System.out.println("Last Name :");
				String lastName = scanner.next();
				contactInfo.setLastName(lastName);

				System.out.println("Phone Number :");
				String phoneNumber = scanner.next();
				contactInfo.setPhoneNumber(phoneNumber);

				System.out.println("Email :");
				String email = scanner.next();
				contactInfo.setEmail(email);

				System.out.println("City :");
				String city = scanner.next();
				contactInfo.setCity(city);

				System.out.println("State :");
				String state = scanner.next();
				contactInfo.setState(state);

				System.out.println("Zip Code :");
				String zipCode = scanner.next();
				contactInfo.setZipCode(zipCode);

				contactList.add(contactInfo);
			} else
				System.out.println("\n: Name Already Exists :");
		} catch (InputMismatchException e) {
			System.out.println("\n: Please Provide Correct Information :");
		}
		return contactList;
	}

	// displayContact Method
	private void displayContact(LinkedList<Contacts> contactList) {
		try {
			System.out.println("All Contacts ::" + contactList.size());
			System.out.println(contactList);
		} catch (Exception e) {
			System.out.println("\n: List Is Empty :");
		}
	}

	// updateContacts Method
	private void updateContact(LinkedList<Contacts> contactList) {
		try {
			System.out.println("Enter the name of the person you want to update the contact of");
			String searchName = scanner.next();
			int editName = searchName(searchName, contactList);

			if (editName == -1)
				System.out.println("\n: Name Not Found :");
			else {
				Contacts contactInfo = contactList.get(editName);
				System.out.println(contactInfo);

				System.out.println("\n: What do you want to update :\n" + "1. First Name \n" + "2. Last Name \n"
						+ "3. Phone Number \n" + "4. Email \n" + "5. City \n" + "6. State \n" + "7. Zip code \n");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("Enter new First Name");
					String newFirstName = scanner.next();
					contactInfo.setFirstName(newFirstName);
				}
					break;
				case 2: {
					System.out.println("Enter new Last Name");
					String newLastName = scanner.next();
					contactInfo.setLastName(newLastName);
				}
					break;
				case 3: {
					System.out.println("Enter new Phone Number");
					String newPhone = scanner.next();
					contactInfo.setPhoneNumber(newPhone);
				}
					break;
				case 4: {
					System.out.println("Enter new Email");
					String newEmail = scanner.next();
					contactInfo.setEmail(newEmail);
				}
					break;
				case 5: {
					System.out.println("Enter new City");
					String newCity = scanner.next();
					contactInfo.setCity(newCity);
				}
					break;
				case 6: {
					System.out.println("Enter new State");
					String newState = scanner.next();
					contactInfo.setState(newState);
				}
					break;
				case 7: {
					System.out.println("Enter new Zip code");
					String newZipcode = scanner.next();
					contactInfo.setZipCode(newZipcode);
				}
					break;
				}
				System.out.println("\n: Updated Successfully :");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// deleteContact Method
	private void deleteContact(LinkedList<Contacts> contactList) {
		try {
			System.out.println("Enter the person name you want to delete the contact details of");
			String searchName = scanner.next();
			int deleteName = searchName(searchName, contactList);

			if (deleteName == -1)
				System.out.println("\n: Name Not Found :");
			else {
				contactList.remove(deleteName);
				System.out.println("\n: Deleted Successfully :");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// searchByLocation Method (Search person by city or state)
	public Hashtable<String, List<String>> searchByLocation(String nameForLocation) {
		try {
			Hashtable<String, List<String>> searchResult = new Hashtable<>();
			List<String> contactList=new ArrayList<>();;
			for (String keyOfBook : contactBook.keySet()) {
				for (int index = 0; index < contactBook.get(keyOfBook).size(); index++) {

					if (contactBook.get(keyOfBook).get(index).getCity().equals(nameForLocation))
						contactList.add(contactBook.get(keyOfBook).get(index).getFirstName());
					
					if (contactBook.get(keyOfBook).get(index).getState().equals(nameForLocation))
						contactList.add(contactBook.get(keyOfBook).get(index).getFirstName());
				}
				if (!contactList.isEmpty())
					searchResult.put(keyOfBook, contactList);
			}
			System.out.println("Persons In City or State ->"+searchResult);
			return searchResult;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// searchName Method
	private int searchName(String searchName, LinkedList<Contacts> contactList) {
		try {
			for (int index = 0; index < contactList.size(); index++) {
				if (contactList.get(index).getFirstName().equals(searchName))
					return index;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}

}
