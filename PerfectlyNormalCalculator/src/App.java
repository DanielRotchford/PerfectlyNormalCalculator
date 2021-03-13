import java.awt.*;  
import java.awt.event.*;
import javax.swing.*; 
import java.lang.StringBuilder;

public class App extends JFrame{
	// Attributes
	GridBagConstraints gbc = new GridBagConstraints();
	JPanel textpanel = new JPanel();
	JTextField textdisplay = new JTextField();
	JTextField prompter = new JTextField();
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
		textpanel.setLayout(new GridBagLayout());
		add(textpanel,gbc);

		gbc.weightx = 1;
		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		Font promptfont = new Font("SansSerif", Font.BOLD,30);
		prompter.setText("PROMPT");
		prompter.setEditable(false);
		prompter.setFont(promptfont);
		prompter.setHorizontalAlignment(JTextField.CENTER);
		textpanel.add(prompter, gbc);

		gbc.weightx = 1;
		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		textdisplay.setEditable(false);
		Font displayfont = new Font("SansSerif", Font.BOLD,50);
		textdisplay.setFont(displayfont);
		textdisplay.setHorizontalAlignment(JTextField.RIGHT);
		textpanel.add(textdisplay, gbc);

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

		// Declare initial String variables
		String divide = "/";
		String multiply = "x";
		String subtract = "-";
		String add = "+";
		String nine = "9";
		String eight = "8";
		String seven = "7";
		String six = "6";
		String five = "5";
		String four = "4";
		String three = "3";
		String two = "2";
		String one = "1";
		String zero = "0";
		String decimal = ".";
		
		// Set up the Calculator Panel
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		JButton buttonAC = new JButton("AC");
		gbc.gridx = 0;
		gbc.gridy = 0;
		buttonAC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	clearTextField();
        	}  
    	});
		calculatorpanel.add(buttonAC,gbc);
		JButton buttonBackspace = new JButton("<");
		gbc.gridx = 1;
		gbc.gridy = 0;
		buttonBackspace.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextFieldBackspace();
        	}  
    	});
		calculatorpanel.add(buttonBackspace,gbc);
		JButton buttonPercent = new JButton("%");
		gbc.gridx = 2;
		gbc.gridy = 0;
		buttonPercent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String percent = " " + divide + " " + one + zero + zero;
            	updateTextField(percent);
        	}  
    	});
		calculatorpanel.add(buttonPercent,gbc);
		CalcButton buttonDivide = new CalcButton(divide);
		gbc.gridx = 3;
		gbc.gridy = 0;
		buttonDivide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(" " + buttonDivide.value + " ");
        	}  
    	});
		calculatorpanel.add(buttonDivide,gbc);
		CalcButton buttonMultiply = new CalcButton(multiply);
		gbc.gridx = 3;
		gbc.gridy = 1;
		buttonMultiply.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(" " + buttonMultiply.value + " ");
        	}  
    	});
		calculatorpanel.add(buttonMultiply,gbc);
		CalcButton buttonSubtract = new CalcButton("-");
		gbc.gridx = 3;
		gbc.gridy = 2;
		buttonSubtract.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(" " + buttonSubtract.value + " ");
        	}  
    	});
		calculatorpanel.add(buttonSubtract,gbc);
		CalcButton buttonAdd = new CalcButton(add);
		gbc.gridx = 3;
		gbc.gridy = 3;
		buttonAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(" " + buttonAdd.value + " ");
        	}  
    	});
		calculatorpanel.add(buttonAdd,gbc);
		JButton buttonCompute = new JButton("=");
		gbc.gridx = 3;
		gbc.gridy = 4;
		buttonCompute.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	Calculate();
        	}  
    	});
		calculatorpanel.add(buttonCompute,gbc);


		// Setting up Numpad
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		numpad.setLayout(new GridBagLayout());
		CalcButton button7 = new CalcButton(seven);
		gbc.gridx = 0;
		gbc.gridy = 0;
		button7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(button7.value);
        	}  
    	});
		numpad.add(button7,gbc);
		CalcButton button8 = new CalcButton(eight);
		gbc.gridx = 1;
		gbc.gridy = 0;
		button8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(button8.value);
        	}  
    	});
		numpad.add(button8,gbc);
		CalcButton button9 = new CalcButton(nine);
		gbc.gridx = 2;
		gbc.gridy = 0;
		button9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(button9.value);
        	}  
    	});
		numpad.add(button9,gbc);
		CalcButton button4 = new CalcButton(four);
		gbc.gridx = 0;
		gbc.gridy = 1;
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(button4.value);
        	}  
    	});
		numpad.add(button4,gbc);
		CalcButton button5 = new CalcButton(five);
		gbc.gridx = 1;
		gbc.gridy = 1;
		button5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(button5.value);
        	}  
    	});
		numpad.add(button5,gbc);
		CalcButton button6 = new CalcButton(six);
		gbc.gridx = 2;
		gbc.gridy = 1;
		button6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(button6.value);
        	}  
    	});
		numpad.add(button6,gbc);
		CalcButton button1 = new CalcButton(one);
		gbc.gridx = 0;
		gbc.gridy = 2;
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(button1.value);
        	}  
    	});
		numpad.add(button1,gbc);
		CalcButton button2 = new CalcButton(two);
		gbc.gridx = 1;
		gbc.gridy = 2;
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(button2.value);
        	}  
    	});
		numpad.add(button2,gbc);
		CalcButton button3 = new CalcButton(three);
		gbc.gridx = 2;
		gbc.gridy = 2;
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(button3.value);
        	}  
    	});
		numpad.add(button3,gbc);
		CalcButton buttonDecimal = new CalcButton(decimal);
		gbc.gridx = 2;
		gbc.gridy = 3;
		buttonDecimal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextFieldDecimal(buttonDecimal.value);
        	}  
    	});
		numpad.add(buttonDecimal,gbc);
		CalcButton button0 = new CalcButton(zero);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		button0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
            	updateTextField(button0.value);
        	}  
    	});
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

	public void updateTextFieldDecimal(String input){
    	String currentText = this.textdisplay.getText();
    	if (currentText.charAt(currentText.length() - 1) == '.'){
    			return;
    	}
    	StringBuilder textbuilder = new StringBuilder(currentText);
    	textbuilder.append(input);
    	String output = textbuilder.toString();
    	this.textdisplay.setText(output);
    }

    public void updateTextFieldBackspace(){
    	String currentText = this.textdisplay.getText();
    	if (currentText.length() < 1){
    		return;
    	}
    	StringBuilder textbuilder = new StringBuilder(currentText);
    	int endIndex = textbuilder.length() - 1;
    	textbuilder.deleteCharAt(endIndex);
    	String output = textbuilder.toString();
    	this.textdisplay.setText(output);
    }

    public void clearTextField(){
    	this.textdisplay.setText("");
    }

    public void computeWithTextField(){
    	String currentText = this.textdisplay.getText();
    	// Calculator.compute(currentText);
    }

	public void Calculate() {
		Calculator c = new Calculator();
		String calcString = textdisplay.getText();
		String result = c.calculate(calcString);
		textdisplay.setText(result);
	}
}
