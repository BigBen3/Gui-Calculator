import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui_Calc_ extends JFrame implements ActionListener {

	// Initialization
	private double x, y, answer;
	private String operator = " ";
	JTextField textField = new JTextField();
	JTextField field = new JTextField();
	Button[] buttons = new Button[20];
	Button add = new OperatorButton("+");
	Button subtract = new OperatorButton("-");
	Button multiply = new OperatorButton("X");
	Button divide = new OperatorButton("/");
	Button equal = new Button("=");
	Button clear = new Button("CE");
	
		


	Gui_Calc_() {

		// Frame
		this.setSize(650, 650);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculator");
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
 
		ImageIcon image = new ImageIcon("calculator.jpg");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(new Color(255, 255, 255));

	
		field.setPreferredSize(new Dimension(250, 40));
		gbc.gridy = 0;
		this.add(field,gbc);
		
		
		textField.setPreferredSize(new Dimension(250, 40));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5, 0, 0, 0);
		this.add(textField,gbc);

		// Creating panel for buttons
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 300));
		panel.setLayout(new GridLayout(4, 4));

		// Creating buttons
		for (int i = 0; i < 10; i++) {
			buttons[i] = new DigitButton(String.valueOf(i));
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		// So formating
			gbc.gridy = 3;
		gbc.insets = new Insets(20, 0, 0, 0); // top padding
		this.add(panel, gbc);
		// Adding listeners
		add.addActionListener(this);
		subtract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		equal.addActionListener(this);
		clear.addActionListener(this);
	
	
		// Adding operation buttons
		panel.add(add);
		panel.add(subtract);
		panel.add(multiply);
		panel.add(divide);
		panel.add(equal);
		panel.add(clear);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Button b = (Button) e.getSource(); // Casts the object into a button. Since I added actionListeners only to
											// button I can cast the source to only buttons because the source will only
											// be buttons. Also getSource returns object. B= e.getSource
		String text = b.getText(); // Sets a string to equal to label of the button.
		if (b instanceof DigitButton) {// Seeing if the source of the action is one of the DigitButton
			textField.setText(textField.getText() + text); // adds text
			field.setText(field.getText() + text);
		} else if (b instanceof OperatorButton) { // Checks if the source of the action is one of the OperatorButtons
			operator = text;// sets operator equal to text
			x = Double.parseDouble(textField.getText());
			field.setText(textField.getText() + text);
			textField.setText("");

		} else if (b == equal) {
			y = Double.parseDouble(textField.getText());

			/*
			 * x = Double.parseDouble(textField.getText().split( Operator, 0)[0]);// So
			 * first you use the get text // method to return the text. It // retunrs a
			 * string. Then you // enter the regex character. // This character will be use
			 * to // split the strings. In our // case the regex character is // reserved so
			 * we have to escape // it by using \\. Then we set // the limit to 0. Meaning
			 * that // the the split method can // split it as many times as it // wants. If
			 * we said a split // limit of 2 then we could only // split it twice. Then we
			 * get // the 0 index of the string // which would be the before the //
			 * operator. y = Double.parseDouble(textField.getText().split( Operator, 0)[1]);
			 * 
			 */

			switch (operator) {
			case "+":
				answer = x + y;
				System.out.println(answer);
				break;
			case "-":
				answer = x - y;
				break;
			case "X":
				answer = x * y;
				break;
			case "/":
				answer = x / y;
				break;

			}
			field.setText(field.getText() + "=" + answer);
			textField.setText(Double.toString(answer));
		}

		if (b == clear) {
			x = 0;
			y = 0;
			textField.setText(" ");
			field.setText("");
		}
		

	}
	public void placeComp(Component comp, JFrame frame, int x, int y, int w, int h) {
		   GridBagConstraints cons = new GridBagConstraints();
		   cons.gridx = x;
		   cons.gridy = y;
		   cons.gridwidth = w;
		   cons.gridheight = h;
		   this.add(comp, cons);
		 } //Use this method when you are going to use the gridbaglayout. 
}
