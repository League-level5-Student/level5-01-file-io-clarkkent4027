package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		/*
		 * JFileChooser jfc = new JFileChooser();
		 * jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); int returnVal =
		 * jfc.showOpenDialog(null); if (returnVal == JFileChooser.APPROVE_OPTION) {
		 * File directory = jfc.getSelectedFile(); File[] files = directory.listFiles();
		 * if(files != null) { for(File f : files) {
		 * System.out.println(f.getAbsolutePath()); } } }
		 * 
		 * /* Your task is to write a program that iterates through the src folder of
		 * this current Java Project. For every .java file it finds, the program will
		 * add a (non-legally binding) copyright statement at the bottom. Be aware of
		 * possible directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */
		JFileChooser myFirstFileChooser = new JFileChooser("/Users/league/git/level5-01-file-io-clarkkent4027/src");
		myFirstFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVa = myFirstFileChooser.showOpenDialog(null);
		if (returnVa == JFileChooser.APPROVE_OPTION) {
			File direct = myFirstFileChooser.getSelectedFile();
			File[] file = direct.listFiles();
			if (file != null) {
				for (File f : file) {
					try {
						if (f.getName().contains(".java")) {
							FileWriter fw = new FileWriter("src/_.txt");
							fw.write("\n//Copyright © 2024 Devin Moorjani");
							fw.close();
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(f.getAbsolutePath());
				}
			}

		}
	}

}
