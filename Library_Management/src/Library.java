import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Library extends JFrame implements ActionListener {
	
	public JTextArea text;
	private JPanel panel;
	private JLabel label;
	private JButton button;
	private JTextField field;
	private JScrollPane scroll;
	private InputHandler handler;
	private String mode = "initial";
	
	public Library(InputHandler handle) {
		handler = handle;
		buildLibrary();
	}

	private void buildLibrary() {
		this.setTitle("Widener Memorial Library");
		this.setLayout(new BorderLayout());
		
		Font font = new Font("Serif", Font.BOLD,15);

		text = new JTextArea();
		text.setFont(font);
		text.setEditable(false);
		text.setWrapStyleWord(true);
		text.setLineWrap(true);
		text.setBackground(Color.black);
		text.setForeground(Color.white);
		
		panel = new JPanel(new GridLayout(3,1));
		label = new JLabel("What is your choice?");
		
		button = new JButton("Press");
		button.addActionListener(this);
		
		field = new JTextField();
		field.addActionListener(this);
		scroll = new JScrollPane(text);
		
		panel.add(label);
		panel.add(field);
		panel.add(button);
		
		this.add(panel, BorderLayout.SOUTH);
		this.add(scroll, BorderLayout.CENTER);
		
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = field.getText();
		switch(mode) {
		case "initial":
			handler.handleInput(s);
			if (s.equalsIgnoreCase("S")) {
				mode = "Student";
				LibraryApp.print("You are in Student mode. ");
			} else if (s.equalsIgnoreCase("L")) {
				mode = "Librarian";
				LibraryApp.print("You are in Librarian mode. ");
			}
			break;
		case "Student":
			handler.runSmenu(s);
			break;
		case "Librarian":
			handler.runLmenu(s);
			break;
		}
		field.setText("");
	
	}
	
}
