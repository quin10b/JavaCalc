import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textField;

	// holds all the numbers for the calc 0-9
	JButton[] numButton = new JButton[10];

	// holds all the functions for the calc +,-,x,/
	JButton[] functions = new JButton[9];
	JButton add, sub, multi, div, del, equal, dec, clr,neg;

	JPanel panel;

	Font font = new Font("Helvetica", Font.BOLD, 30);

	double num1 = 0, num2 = 0, result;
	char operator;

	Calculator() {
		frame = new JFrame("Calculator");

		// Allows user to exit calc
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(420, 550);
		frame.setLayout(null);

		textFieldAux();
		buttonAux();

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		//panel.setBackground(Color.black);
		

		panel.add(numButton[1]);
		panel.add(numButton[2]);
		panel.add(numButton[3]);
		panel.add(add);
		panel.add(numButton[4]);
		panel.add(numButton[5]);
		panel.add(numButton[6]);
		panel.add(sub);
		panel.add(numButton[7]);
		panel.add(numButton[8]);
		panel.add(numButton[9]);
		panel.add(multi);
		panel.add(dec);
		panel.add(numButton[0]);
		panel.add(equal);
		panel.add(div);

		frame.add(panel);
		frame.add(neg);
		frame.add(clr);
		frame.add(del);
		frame.add(textField);
		frame.setVisible(true);

	}

	private void textFieldAux() {
		// creates field for the output of the numbers entered
		textField = new JTextField();
		// textField.setBounds(x,y,width,height);
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(font);
		textField.setEditable(false);
	}

	private void buttonAux() {
		ArrayList<JButton> temp = new ArrayList<>();

		temp.add(add = new JButton("+"));
		temp.add(sub = new JButton("-"));
		temp.add(multi = new JButton("x"));
		temp.add(div = new JButton("\u00F7"));
		temp.add(del = new JButton("del"));
		temp.add(equal = new JButton("="));
		temp.add(dec = new JButton("."));
		temp.add(clr = new JButton("clr"));
		temp.add(neg = new JButton("neg"));


		for (int i = 0; i < temp.size(); i++) {

			functions[i] = temp.get(i);

			// allows buttons to be able to be interacted with
			functions[i].addActionListener(this);
			functions[i].setFont(font);

			// removes lines around buttons when clicking
			functions[i].setFocusable(false);

		}

		for (int i = 0; i < numButton.length; i++) {
			numButton[i] = new JButton(String.valueOf(i));
			numButton[i].addActionListener(this);
			numButton[i].setFont(font);

			// removes lines around buttons when clicking
			numButton[i].setFocusable(false);
		}

		neg.setBounds(50,430,100,50);
		del.setBounds(150, 430, 100, 50);
		clr.setBounds(250, 430, 100, 50);

	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();
		
		char divi = '\u00F7';
		System.out.println();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numButton[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}

		if (e.getSource() == dec) {
			textField.setText(textField.getText().concat("."));
		}
		if (e.getSource() == add) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if (e.getSource() == sub) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if (e.getSource() == multi) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if (e.getSource() == div) {
			num1 = Double.parseDouble(textField.getText());
			operator = '\u00F7';
			textField.setText("");
		}
		if (e.getSource() == equal) {
			num2 = Double.parseDouble(textField.getText());

			switch (operator) {
			case '+':
				result = num1 + num2;
				break;

			case '-':
				result = num1 - num2;
				break;

			case '*':
				result = num1 * num2;
				break;
			case '\u00F7':
				result = num1 / num2;
				break;
			}
			
			textField.setText(String.valueOf(result));
			num1=result;
			
		}

		if (e.getSource() == clr) {
			textField.setText("");
		}
		if (e.getSource() == del) {
			String string = textField.getText();
			textField.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textField.setText(textField.getText()+string.charAt(i));
				
			}
		}
		if (e.getSource() == neg) {
			double temp = Double.parseDouble(textField.getText());
			temp*=-1;
			textField.setText(String.valueOf(temp));
		}

	}

}
