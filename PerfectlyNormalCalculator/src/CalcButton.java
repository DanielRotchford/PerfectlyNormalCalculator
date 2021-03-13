import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;  

public class CalcButton extends JButton{
	String value;

	public CalcButton(String newvalue){
		this.value = newvalue;
		setText(value);
	}
}