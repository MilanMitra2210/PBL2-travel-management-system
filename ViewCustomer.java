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
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ViewCustomer extends JFrame implements ActionListener {
	
	String username;
	JButton  b2;
	JLabel l11, l12 ,l13 ,l14  ,l16, l17 , l18 ,l19;
	JTextArea l15;
	
	public ViewCustomer(String username) {
		
		this.username = username;
		
		setBounds(300 , 50 , 950, 625);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l0 = new JLabel("DETAILS");
		l0.setBounds(400 , 10 , 300 , 18);
		l0.setFont(new Font("Tahoma", Font.BOLD,18));
		l0.setForeground(Color.RED);
		add(l0);
		
		JLabel l1 = new JLabel("Username :");
		l1.setBounds(30 , 50 , 150 , 25);
		l1.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l1);
		
		l11 = new JLabel();
		l11.setBounds(220, 50, 150, 25);
		l11.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l11);
		
		JLabel l2 = new JLabel("ID :");
		l2.setBounds(30 , 110 , 150 , 25);
		l2.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l2);
		
		l18 = new JLabel();
		l18.setBounds(220, 110, 150, 25);
		l18.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l18);
		
		JLabel l3 = new JLabel("ID Number :");
		l3.setBounds(30 , 170 , 150 , 25);
		l3.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l3);
		
		l12 = new JLabel();
		l12.setBounds(220, 170, 150, 25);
		l12.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l12);
		
		JLabel l4 = new JLabel("Name :");
		l4.setBounds(30 , 230 , 150 , 25);
		l4.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l4);
		
		l13 = new JLabel();
		l13.setBounds(220, 230, 150, 25);
		l13.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l13);
		
		JLabel l5 = new JLabel("Gender :");
		l5.setBounds(30 , 290 , 150 , 25);
		l5.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l5);
		
		l19 = new JLabel();
		l19.setBounds(220, 290, 150, 25);
		l19.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l19);
		
		JLabel l6 = new JLabel("Country :");
		l6.setBounds(550 , 50 , 150 , 25);
		l6.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l6);
		
		l14 = new JLabel();
		l14.setBounds(690 , 50 , 150 , 25);
		l14.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l14);
		
		JLabel l7 = new JLabel("Address :");
		l7.setBounds(550 , 130 , 150 , 25);
		l7.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l7);
		
		l15 = new JTextArea();
		l15.setEditable(false);
		l15.setLineWrap(true);
		l15.setWrapStyleWord(true);
		l15.setBounds(690, 130, 200, 80);
		l15.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l15);
		
		JLabel l8 = new JLabel("Phone Number :");
		l8.setBounds(550 , 210 , 150 , 25);
		l8.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l8);
		
		l16 = new JLabel();
		l16.setBounds(690, 210, 150, 25);
		l16.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l16);
		
		JLabel l9 = new JLabel("Email :");
		l9.setBounds(550 , 290 , 150 , 25);
		l9.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l9);
		
		l17 = new JLabel();
		l17.setBounds(690, 290, 250, 25);
		l17.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l17);
		
		b2 = new JButton("Back");
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setBounds(370, 350, 100, 25);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource
				("travel/management/system/icons/viewall.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l10 = new JLabel(i3);
		l10.setBounds(140, 400, 600, 200);
		add(l10);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.stmt.executeQuery
					("SELECT * FROM customer WHERE username = '" + this.username + "';");
			while(rs.next()) {
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("number"));
				l13.setText(rs.getString("name"));
				l14.setText(rs.getString("country"));
				l15.setText(rs.getString("address"));
				l16.setText(rs.getString("phone_number"));
				l17.setText(rs.getString("email"));
				l18.setText(rs.getString("id"));
				l19.setText(rs.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		new ViewCustomer("Milan2210").setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b2) {
			dispose();
		}
		
	}
}
