package Code.NoteApp;

import java.io.*;
import java.util.Scanner;

public class NotesApp {
	private static final String FILE_NAME = "notes.txt";

	public static void writeNote() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your note: ");
		String note = sc.nextLine();

		try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
			fw.write(note + System.lineSeparator());
			System.out.println("Note saved successfully!");
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

	public static void readNotes() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			System.out.println("\n--- Your Notes ---");
			while ((line = br.readLine()) != null) {
				System.out.println("- " + line);
			}
			System.out.println("------------------\n");
		} catch (FileNotFoundException e) {
			System.out.println("No notes found. Start writing some!");
		} catch (IOException e) {
			System.out.println("Error reading from file: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("***** Notes App *****");
			System.out.println("1. Write a Note");
			System.out.println("2. Read Notes");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1 -> writeNote();
			case 2 -> readNotes();
			case 3 -> System.out.println("Exiting... Thank you for using me!");
			default -> System.out.println("Invalid choice! Try again.");
			}
		} while (choice != 3);

		sc.close();
	}
}
