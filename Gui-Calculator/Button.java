import java.awt.Color;

import javax.swing.JButton;
public class Button extends JButton{
	Button(String label) { 
		super(label); // takes parameter and use it to set label in super class JButton
		super.setFocusable(false);
		super.setSize(200,200);
		super.setBackground(new Color(225,225,225));
	}
	public void setActionCommand(int i) {
		// TODO Auto-generated method stub
		
	}
}
