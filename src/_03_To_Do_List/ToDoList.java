package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {

	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton("Add Task");
	JButton b2 = new JButton("View Tasks");
	JButton b3 = new JButton("Remove Task");
	JButton b4 = new JButton("Save List");
	JButton b5 = new JButton("Load List");
	ArrayList<String> tasks = new ArrayList<String>();

	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		list.setUp();
	}

	public void setUp() {
		try {
			BufferedReader b = new BufferedReader(new FileReader("src/_03_To_Do_List/toDoList"));
			String line = b.readLine();
			while (line != null) {
				System.out.println(line);
				line = b.readLine();
			}

			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panel.setSize(50, 100);
		frame.setSize(100, 100);
		frame.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		frame.add(panel);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		frame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			String add = JOptionPane.showInputDialog(null, "Please enter a task to add:");
			tasks.add(add);
		}
		if (e.getSource() == b2) {
			System.out.println(" ");
			for (int i = 0; i < tasks.size(); i++) {

				System.out.println(tasks.get(i));
			}
		}
		if (e.getSource() == b3) {
			String remove = JOptionPane.showInputDialog(null, "Please enter a task to remove:");
			for (int i = 0; i < tasks.size(); i++) {
				if (tasks.get(i).equalsIgnoreCase(remove)) {
					tasks.remove(i);
				}
			}
		}
		if (e.getSource() == b4) {
			try {
				String name = JOptionPane.showInputDialog(null, "Please enter the location of the file:");
				FileWriter write = new FileWriter("src/_03_To_Do_List/" + name + ".txt");
				FileWriter write2 = new FileWriter("src/_03_To_Do_List/toDoList.txt");
				for (int i = 0; i < tasks.size(); i++) {
					write.write(tasks.get(i) + "\n");
					write2.write(tasks.get(i) + "\n");
				}

				System.out.println("List Saved!");
				write.close();
				write2.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == b5) {
			String name = JOptionPane.showInputDialog("Please enter the location of the file:");
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/" + name + ".txt"));
				String l = br.readLine();
				while (l != null) {
					System.out.println(l);
					l = br.readLine();
				}
				br.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
}
