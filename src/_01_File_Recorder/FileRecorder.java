package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {

		// Create a program that takes a message from the user and saves it to a file.

		String message = JOptionPane.showInputDialog(null, "Please enter a message!");
		FileWriter writer;
		try {
			writer = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test.txt", true);

			writer.write(message);
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
