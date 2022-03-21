package travel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BookHotel extends JFrame {

	String username;
	Choice c1 , c2 , c3;
	JTextField t1 , t2;
	JLabel l21 , l22 , l23 , l24 , l25;
	JButton b1 , b2 , b3;
	
	BookHotel(String username) {
		
		this.username = username;
		
		setBounds(250, 150, 1100, 600);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("BOOK HOTEL");
		l1.setFont(new Font("Tahoma" , Font.PLAIN , 24));
		l1.setBounds(100, 0, 300, 30);
		add(l1);
		
		JLabel l2 = new JLabel("Username: ");
		l2.setBounds(30, 70, 100, 30);
		add(l2);
		
		l21 = new JLabel();
		l21.setBounds(250, 70, 150, 30);
		add(l21);
		
		JLabel l3 = new JLabel("Select Hotel");
		l3.setBounds(30, 110, 100, 30);
		add(l3);
		
		c1 = new Choice();
		c1.add("JW Marriot Hotel");
		c1.add("Mandarin Oriental Hotel");
		c1.setBounds(250 ,110 , 150 , 30);
		add(c1);
		
		JLabel l4 = new JLabel("Total Persons: ");
		l4.setBounds(30, 150, 100, 30);
		add(l4);
		
		t1 = new JTextField();
		t1.setBounds(250, 150, 150, 25);
		add(t1);
		
		JLabel l5 = new JLabel("No. of Days: ");
		l5.setBounds(30, 190, 100, 30);
		add(l5);
		
		t1 = new JTextField();
		t1.setBounds(250, 190, 150, 25);
		add(t1);
		
		JLabel l6 = new JLabel("AC / Non-AC");
		l6.setBounds(30, 230, 100, 30);
		add(l6);
		
		c2 = new Choice();
		c2.add("AC");
		c2.add("Non-AC");
		c2.setBounds(250 ,230 , 150 , 30);
		add(c2);
		
		JLabel l7 = new JLabel("Food Included");
		l7.setBounds(30, 270, 100, 30);
		add(l7);
		
		c3 = new Choice();
		c3.add("Yes");
		c3.add("No");
		c3.setBounds(250 ,270 , 150 , 30);
		add(c3);
		
		JLabel l8 = new JLabel("ID: ");
		l8.setBounds(30, 310, 100, 30);
		add(l8);
		
		l22 = new JLabel();
		l22.setBounds(250, 310, 150, 30);
		add(l22);
		
		JLabel l9 = new JLabel("ID Number: ");
		l9.setBounds(30, 350, 100, 30);
		add(l9);
		
		l23 = new JLabel();
		l23.setBounds(250, 350, 150, 30);
		add(l23);
		
		JLabel l10 = new JLabel("Phone Number: ");
		l10.setBounds(30, 390, 100, 30);
		add(l10);
		
		l24 = new JLabel();
		l24.setBounds(250, 390, 150, 30);
		add(l24);
		
		JLabel l11 = new JLabel("Total Price: ");
		l11.setBounds(30, 430, 100, 30);
		add(l11);
		
		l25 = new JLabel();
		l25.setForeground(Color.RED);
		l25.setBounds(250, 430, 150, 30);
		add(l25);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.stmt.executeQuery
					("SELECT * FROM customer WHERE username = '"
			+ username + "';");
			
			while(rs.next()) {
				l21.setText(rs.getString("username"));
				l22.setText(rs.getString("ID"));
				l23.setText(rs.getString("number"));
				l24.setText(rs.getString("phone_number"));
			}
		}catch (Exception e) {
			
		}
		
		b1 = new JButton("Check Price");
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		b1.setBounds(30, 490, 110, 25);
		add(b1);
		
		b2 = new JButton("Book");
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		b2.setBounds(150, 490, 110, 25);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.BLUE);
		b3.setForeground(Color.WHITE);
		b3.setBounds(270, 490, 110, 25);
		add(b3);
		
	}
	public static void main(String[] args) {
		new BookHotel("Milan2210").setVisible(true);
	}
}
