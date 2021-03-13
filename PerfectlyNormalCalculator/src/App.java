import java.awt.*;  
import java.awt.event.*;
import javax.swing.*; 
import java.lang.StringBuilder;

public class App extends JFrame{
	// Attributes
	GridBagConstraints gbc = new GridBagConstraints();
	JPanel textpanel = new JPanel();
	JTextField textdisplay = new JTextField();
	JPanel calculatorpanel = new JPanel();
	JPanel numpad = new JPanel();

    public static void main(String[] args) throws Exception {
        App app = new App();
    }

    // Constructor
    public App(){
    	setTitle("Calculator App");
    	setLayout(new GridBagLayout());
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Headbar is added
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 0.2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(textpanel,gbc);

		textdisplay.setEditable(false);
		textdisplay.setPreferredSize( new Dimension(600,120));
		textdisplay.setHorizontalAlignment(JTextField.RIGHT);
		textdisplay.setText("placeholder");
		textpanel.add(textdisplay);

		// Calculator Panel is added
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 0.80;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		calculatorpanel.setLayout(new GridBagLayout());
		add(calculatorpanel,gbc);

		// Set up the Calculator Panel
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JButton buttonAC = new JButton("AC");
		gbc.gridx = 0;
		gbc.gridy = 0;
		calculatorpanel.add(buttonAC,gbc);
		JButton buttonBackspace = new JButton("<");
		gbc.gridx = 1;
		gbc.gridy = 0;
		calculatorpanel.add(buttonBackspace,gbc);
		JButton buttonPercent = new JButton("%");
		gbc.gridx = 2;
		gbc.gridy = 0;
		calculatorpanel.add(buttonPercent,gbc);
		JButton buttonDivide = new JButton("÷");
		gbc.gridx = 3;
		gbc.gridy = 0;
		calculatorpanel.add(buttonDivide,gbc);
		JButton buttonMultiply = new JButton("×");
		gbc.gridx = 3;
		gbc.gridy = 1;
		calculatorpanel.add(buttonMultiply,gbc);
		JButton buttonSubtract = new JButton("-");
		gbc.gridx = 3;
		gbc.gridy = 2;
		calculatorpanel.add(buttonSubtract,gbc);
		JButton buttonAdd = new JButton("+");
		gbc.gridx = 3;
		gbc.gridy = 3;
		calculatorpanel.add(buttonAdd,gbc);
		JButton buttonCompute = new JButton("=");
		gbc.gridx = 3;
		gbc.gridy = 4;
		calculatorpanel.add(buttonCompute,gbc);


		// Setting up Numpad
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		numpad.setLayout(new GridBagLayout());
		JButton button7 = new JButton("7");
		gbc.gridx = 0;
		gbc.gridy = 0;
		numpad.add(button7,gbc);
		JButton button8 = new JButton("8");
		gbc.gridx = 1;
		gbc.gridy = 0;
		numpad.add(button8,gbc);
		JButton button9 = new JButton("9");
		gbc.gridx = 2;
		gbc.gridy = 0;
		numpad.add(button9,gbc);
		JButton button4 = new JButton("4");
		gbc.gridx = 0;
		gbc.gridy = 1;
		numpad.add(button4,gbc);
		JButton button5 = new JButton("5");
		gbc.gridx = 1;
		gbc.gridy = 1;
		numpad.add(button5,gbc);
		JButton button6 = new JButton("6");
		gbc.gridx = 2;
		gbc.gridy = 1;
		numpad.add(button6,gbc);
		JButton button1 = new JButton("1");
		gbc.gridx = 0;
		gbc.gridy = 2;
		numpad.add(button1,gbc);
		JButton button2 = new JButton("2");
		gbc.gridx = 1;
		gbc.gridy = 2;
		numpad.add(button2,gbc);
		JButton button3 = new JButton("3");
		gbc.gridx = 2;
		gbc.gridy = 2;
		numpad.add(button3,gbc);
		JButton buttonDecimal = new JButton(".");
		gbc.gridx = 2;
		gbc.gridy = 3;
		numpad.add(buttonDecimal,gbc);
		JButton button0 = new JButton("0");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		numpad.add(button0,gbc);

		gbc.weightx = 0.75;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 4;
		calculatorpanel.add(numpad,gbc);

		// Make the window visible
		setVisible(true);
    }

    public void updateTextField(String input){
    	String currentText = this.textdisplay.getText();
    	StringBuilder textbuilder = new StringBuilder(currentText);
    	textbuilder.append(input);
    	String output = textbuilder.toString();
    	this.textdisplay.setText(output);
    }

    public void updateTextField(int input){
    	String currentText = this.textdisplay.getText();
    	StringBuilder textbuilder = new StringBuilder(currentText);
    	textbuilder.append(input);
    	String output = textbuilder.toString();
    	this.textdisplay.setText(output);
    }
}
