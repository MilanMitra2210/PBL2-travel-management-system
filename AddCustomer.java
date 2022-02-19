package travel.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddCustomer extends JFrame {
	
	JTextField t1, t2 ,t3 ,t4;
	
	public AddCustomer() {
		
		setBounds(300 , 150 , 850 , 550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(30 , 50 , 150 , 25);
		l1.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(220, 50, 150, 25);
		t1.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(t1);
	}
	
	public static void main(String[] args) {
		new AddCustomer().setVisible(true);
	}
}
