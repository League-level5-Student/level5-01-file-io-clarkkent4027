import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class _10_Text_Editor implements ActionListener {
	JFrame frame;
	JTextArea area;
	JPanel panel;
	JButton save;
	JButton load;

	public static void main(String[] args) {
		_10_Text_Editor text = new _10_Text_Editor();
		text.setup();
	}

	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		save = new JButton("Save");
		load = new JButton("Load");
		area = new JTextArea(40, 80);

		frame.add(panel);
		panel.add(area);
		panel.add(save);
		panel.add(load);
		frame.setVisible(true);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.setSize(250, 250);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == save) {

			save();

		} else if (e.getSource() == load) {
			try {
				load();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void load() throws IOException {
		String str = "";
		String input = JOptionPane.showInputDialog(null, "Enter the name of the file you want to load:");
		BufferedReader reader = new BufferedReader(new FileReader("src/league_token/" + input));
		try {

			String line = reader.readLine();
			System.out.println(line);
			while (line != null) {
				str += line + "\n";
				line = reader.readLine();
				System.out.println(line);
			}
			reader.close();
			area.setText(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save() {
		String input = JOptionPane.showInputDialog(null, "Enter the name of the file you want to save to:");
		try {
			FileWriter writer = new FileWriter("src/league_token/" + input);
			writer.write(area.getText() + "\n");
			System.out.println(area.getText());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
