package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ViewPackage extends JFrame implements ActionListener {

	String username;
	JButton b1; 
	 
	ViewPackage(String username){
		
		this.username = username;
		setBounds(300 , 240 , 1000 , 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource
				("travel/management/system/icons/bookedDetails.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l10 = new JLabel(i3);
		l10.setBounds(450 , 20 , 500 , 350);
		add(l10);
		
		JLabel heading = new JLabel("VIEW PACKAGE DETAILS");
		heading.setBounds(60, 0, 300, 30);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(heading);
		
		JLabel l1 = new JLabel("Username: ");
		l1.setBounds(30, 50, 100, 30);
		add(l1);
		
		JLabel l11 = new JLabel();
		l11.setBounds(250, 50, 200, 30);
		add(l11);
		
		JLabel l2 = new JLabel("Package: ");
		l2.setBounds(30, 90, 100, 30);
		add(l2);
		
		JLabel l12 = new JLabel();
		l12.setBounds(250, 90, 200, 30);
		add(l12);
		
		JLabel l3 = new JLabel("Total Persons: ");
		l3.setBounds(30, 130, 100, 30);
		add(l3);
		
		JLabel l13 = new JLabel();
		l13.setBounds(250, 130, 200, 30);
		add(l13);
		
		JLabel l4 = new JLabel("ID: ");
		l4.setBounds(30, 170, 100, 30);
		add(l4);
		
		JLabel l14 = new JLabel();
		l14.setBounds(250, 170, 200, 30);
		add(l14);
		
		JLabel l5 = new JLabel("ID Number: ");
		l5.setBounds(30, 210, 100, 30);
		add(l5);
		
		JLabel l15 = new JLabel();
		l15.setBounds(250, 210, 200, 30);
		add(l15);
		
		JLabel l6 = new JLabel("Phone Number: ");
		l6.setBounds(30, 250, 100, 30);
		add(l6);
		
		JLabel l16 = new JLabel();
		l16.setBounds(250, 250, 200, 30);
		add(l16);
		
		JLabel l7 = new JLabel("Price: ");
		l7.setBounds(30, 290, 100, 30);
		add(l7);
		
		JLabel l17 = new JLabel();
		l17.setBounds(250, 290, 200, 30);
		add(l17);
		
		try {
			
			Conn c = new Conn();
			ResultSet rs = c.stmt.executeQuery
					("SELECT * FROM bookPackage WHERE username ='" + username +"';");
			while(rs.next()) {
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("package"));
				l13.setText(rs.getString("persons"));
				l14.setText(rs.getString("id"));
				l15.setText(rs.getString("id_number"));
				l16.setText(rs.getString("phone_number"));
				l17.setText(rs.getString("price"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		b1 = new JButton("Back");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(150, 340, 150, 25);
		b1.addActionListener(this);
		add(b1);
	}
	
	public static void main(String[] args) {
		new ViewPackage("Milan2210").setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			dispose();
		}
	}
}
