package travel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Signup extends JFrame implements ActionListener {

	JButton b1 , b2;
	JTextField t1 , t2  ,t4;
	JPasswordField t3;
	Choice c1;
	
	Signup() {
		setBounds(350 ,280 , 900 , 350); 
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(131,193,233));
		p1.setBounds(0 , 0 ,500 , 400);
		p1.setLayout(null);
		add(p1);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(50 , 20 , 135 , 25);
		l1.setFont(new Font("SAN_SERIF",Font.BOLD, 15));
		p1.add(l1);
		
		t1 = new JTextField();
		t1.setBounds(200 , 20 ,180 ,25);
		t1.setFont(new Font("SAN_SERIF",Font.PLAIN, 15));
		t1.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t1);
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(50 , 60 , 135 , 25);
		l2.setFont(new Font("SAN_SERIF",Font.BOLD, 15));
		p1.add(l2);
		
		t2 = new JTextField();
		t2.setBounds(200 , 60 ,180 ,25);
		t2.setFont(new Font("SAN_SERIF",Font.PLAIN, 15));
		t2.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t2);
		
		JLabel l3 = new JLabel("Password");
		l3.setBounds(50 , 100 , 135 , 25);
		l3.setFont(new Font("SAN_SERIF",Font.BOLD, 15));
		p1.add(l3);
		
		t3 = new JPasswordField();
		t3.setBounds(200 , 100 ,180 ,25);
		t3.setFont(new Font("SAN_SERIF",Font.PLAIN, 15));
		t3.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t3);
		
		JLabel l4 = new JLabel("Security Question");
		l4.setBounds(50 , 140 , 135 , 25);
		l4.setFont(new Font("SAN_SERIF",Font.BOLD, 15));
		p1.add(l4);
		
		c1 = new Choice();
		c1.add("Your favorite book?");
		c1.add("Your nickname?");
		c1.add("Your dream place to visit?");
		c1.add("The city in which you were born.");
		c1.setBounds(200,140,225 ,30);
		p1.add(c1);
		
		JLabel l5 = new JLabel("Answer");
		l5.setBounds(50 , 180 , 135 , 25);
		l5.setFont(new Font("SAN_SERIF",Font.BOLD, 15));
		p1.add(l5);
		
		t4 = new JTextField();
		t4.setBounds(200 , 180 ,180 ,25);
		t4.setFont(new Font("SAN_SERIF",Font.PLAIN, 15));
		t4.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t4);
		
		ImageIcon i1 = new ImageIcon(
				ClassLoader.getSystemResource("travel/management/system/icons/signup.png"));
		Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l6 = new JLabel(i3);
		l6.setBounds( 580 , 50 , 250 , 250);
		add(l6);
		
		b1 = new JButton("Create");
		b1.setBounds(80 , 250 , 100 ,30);
		b1.setForeground(new Color(133, 193, 233));
		b1.setBackground(Color.WHITE);
		b1.setFont(new Font("SAN_SERIF",Font.BOLD , 15));
		p1.add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(250 , 250 , 100 ,30);
		b2.setForeground(new Color(133, 193, 233));
		b2.setFont(new Font("SAN_SERIF",Font.BOLD , 15));
		b2.setBackground(Color.WHITE);
		p1.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Signup();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			
			String username = t1.getText();
			String name = t2.getText();
			String password = t3.getText();
			String security = c1.getSelectedItem();
			String answer = t4.getText();
			t4.setText(username);
			
			String query = "Insert into account values"
			+ "('" + username +  "' , '" + name +"', '"
					+ password + "', '" + security + "', '" + answer + "')";
			
			try {
				
				Conn c = new Conn();
				c.stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Account created Successfully");
				
//				this.setVisible(false);
				dispose();
				new Login();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else if(e.getSource() == b2) {
//			this.setVisible(false);
			dispose();
			new Login();
		}
	}
}
