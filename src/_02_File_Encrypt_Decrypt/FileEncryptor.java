package _02_File_Encrypt_Decrypt;

import java.io.IOException;

import javax.swing.JOptionPane;

import java.io.FileWriter;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {

		//	Dahhk pdana. cajanwh gajkxe, ukq wna w xkhz kja. *hecdpowxano ecjepa*  
		
		String input = JOptionPane.showInputDialog(null, "Please enter your message");
		String k = JOptionPane.showInputDialog(null, "Please enter a key");
		int key = Integer.parseInt(k);
		int subtract = 26-key;

		try {

			FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test.txt", true);
			String[] letters = input.split("");
			for (int i = 0; i < letters.length; i++) {
				char c = letters[i].charAt(0);
			if (c >31 && c < 48) {
				
			}else if (c+key > 122) {
				c -= subtract;
			}else {
				c += key;
			}
					
				
		
			
				fw.write(c);
			}

			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}