package travel.management.system;

import java.awt.Choice;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BookPackage extends JFrame implements ActionListener{

	String username;
	JLabel l11 , l12, l13 ,l14 ,l15;
	JTextField t1;
	Choice c1;
	JButton b1 , b2 , b3;
	
	BookPackage(String username) {
		
		this.username = username;
		setBounds(300 , 240 , 1100 ,450);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon
		(ClassLoader.getSystemResource("travel/management/system/icons/bookpackage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l9 = new JLabel(i3);
		l9.setBounds(500, 50, 500, 300);
		add(l9);
		
		JLabel l1 = new JLabel("BOOK PACKAGE");
		l1.setBounds(100, 10, 200, 30);
		l1.setFont(new Font("Yu Mincho",Font.PLAIN , 20));
		add(l1);
		
		JLabel l2 = new JLabel("Username");
		l2.setBounds(40, 70, 100, 30);
		l2.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(l2);
		
		l11 = new JLabel();
		l11.setBounds(250, 70, 200, 30);
		l11.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(l11);
		
		JLabel l3 = new JLabel("Select Package");
		l3.setBounds(40, 110, 150, 30);
		l3.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(l3);
		
		c1 = new Choice();
		c1.add("Gold Package");
		c1.add("Silver Package");
		c1.add("Bronze Package");
		c1.setBounds(250, 120, 200, 30);
		add(c1);
		
		JLabel l4 = new JLabel("Total Persons");
		l4.setBounds(40, 150, 150, 30);
		l4.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(l4);
		
		t1 = new JTextField("1");
		t1.setBounds(250, 150, 200, 25);
		t1.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(t1);
		
		JLabel l5 = new JLabel("ID ");
		l5.setBounds(40, 190, 100, 30);
		l5.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(l5);
		
		l12 = new JLabel();
		l12.setBounds(250, 190, 200, 30);
		l12.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(l12);
		
		JLabel l6 = new JLabel("ID Number ");
		l6.setBounds(40, 230, 150, 30);
		l6.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(l6);
		
		l13 = new JLabel();
		l13.setBounds(250, 230, 200, 30);
		l13.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(l13);
		
		JLabel l7 = new JLabel("Phone Number");
		l7.setBounds(40, 270, 150, 30);
		l7.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(l7);
		
		l14 = new JLabel();
		l14.setBounds(250, 270, 200, 30);
		l14.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(l14);
		
		JLabel l8 = new JLabel("Total Price ");
		l8.setBounds(40, 310, 150, 30);
		l8.setFont(new Font("Tahoma",Font.PLAIN , 20));
		add(l8);
		
		l15 = new JLabel();
		l15.setBounds(250, 310, 200, 30);
		l15.setFont(new Font("Tahoma",Font.PLAIN , 20));
		l15.setForeground(Color.RED);
		add(l15);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.stmt.executeQuery
					("SELECT * FROM customer where username ='"+ this.username +"'");
			
			while(rs.next()) {
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("id"));
				l13.setText(rs.getString("number"));
				l14.setText(rs.getString("phone_number"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		b1 = new JButton("Check Price");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(60, 360, 120, 25);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Book Package");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(200, 360, 120, 25);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(340, 360, 120, 25);
		b3.addActionListener(this);
		add(b3);
		
		
	}
	public static void main(String[] args) {
		new BookPackage("Milan2210").setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			String p = c1.getSelectedItem();
			int cost = 0;
			if(p.equals("Bronze Package")) {
				cost += 12000;
			}else if(p.equals("Silver Package")) {
				cost +=  16000;
			}else if(p.equals("Gold Package")) {
				cost += 22000;
			}
			int persons = Integer.parseInt(t1.getText());
			cost *= persons;
			
			l15.setText("Rs " + cost);
		}else if(e.getSource() == b2) {
			
			try {
				Conn c = new Conn();
				c.stmt.executeUpdate
				("INSERT INTO bookPackage values('"+ l11.getText() +"' , '" +
				 c1.getSelectedItem() + "' , '" + t1.getText() + "' , '" +
				 l12.getText() + "' , '" + l13.getText() + "' , '" + l14.getText() + "' , '"
				 + l15.getText() + "');");
				JOptionPane.showMessageDialog(null, "Package Booked Successfully");
				
				dispose();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}else if(e.getSource() == b3) {
			dispose();
		}
	}
}
