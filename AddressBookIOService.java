package com.assignments.day9.AddressBookSystem;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class AddressBookIOService {
	private static final String FILE_NAME = "ContactDetails.txt";

	// Writing The Contact Details Into A Text File
	public void writeContactDetails(Map<String, List<Contacts>> addressBooks) {
		Path path = Paths.get(FILE_NAME);
		StringBuilder contactDetailsBuilder = new StringBuilder();
		addressBooks.keySet().forEach(keyOfBook -> {
			contactDetailsBuilder.append("\n").append(keyOfBook).append("->\n");
			addressBooks.get(keyOfBook).forEach(contacts -> {
				String string = contacts.toString();
				contactDetailsBuilder.append(string);
			});
		});

		try {
			Files.deleteIfExists(path);
			Files.write(path, contactDetailsBuilder.toString().getBytes());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// Reading The Details That Are Written In Text File
	public static void readContactDetails() throws IOException {
		String fileURL = "C:\\Users\\AMAN\\eclipse-workspace\\AddressBookSystem\\ContactDetails.txt";
		int dataPositionPresent;
		FileReader fileReaderObject = new FileReader(fileURL);
		while ((dataPositionPresent = fileReaderObject.read()) != -1)
			System.out.print((char) dataPositionPresent);
		fileReaderObject.close();
	}

	// Main Method
	public static void main(String[] args) throws IOException {
		readContactDetails();
	}
}