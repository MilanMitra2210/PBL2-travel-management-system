package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UpdateCustomer extends JFrame implements ActionListener {
	
	String username;
	JTextField t1, t2 ,t3 ,t4 , t5 ,t6, t7 , t8 ,t9;
	JLabel label , label2;
	JButton b1 , b2;
	
	public UpdateCustomer(String username) {
		
		this.username = username;
		
		setBounds(400 , 150 , 850 , 550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l0 = new JLabel("UPDATE CUSTOMER DETAILS");
		l0.setBounds(55 , 10 , 300 , 18);
		l0.setFont(new Font("Tahoma", Font.BOLD,18));
		l0.setForeground(Color.RED);
		add(l0);
		
		JLabel l1 = new JLabel("Username :");
		l1.setBounds(30 , 50 , 150 , 25);
		l1.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(220, 50, 150, 25);
		t1.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(t1);
		
		JLabel l2 = new JLabel("ID :");
		l2.setBounds(30 , 90 , 150 , 25);
		l2.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l2);
		
		t8 = new JTextField();
		t8.setBounds(220, 90, 150, 25);
		t8.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(t8);
		
		JLabel l3 = new JLabel("ID Number :");
		l3.setBounds(30 , 130 , 150 , 25);
		l3.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(220, 130, 150, 25);
		t2.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(t2);
		add(label = new JLabel());
		label.setBounds(220, 155, 180, 12);
		label.setFont(new Font("Tahoma", Font.BOLD,9));
		label.setForeground(Color.RED);
		t2.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
	            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\b') {
	               t2.setEditable(true);
	               label.setText("");
	            } else {
	               t2.setEditable(false);
	               label.setText("* Enter only numeric digits(0-9)");
	            }
			}
			
		});
		
		JLabel l4 = new JLabel("Name :");
		l4.setBounds(30 , 170 , 150 , 25);
		l4.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l4);
		
		t3 = new JTextField();
		t3.setBounds(220, 170, 150, 25);
		t3.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(t3);
		
		JLabel l5 = new JLabel("Gender :");
		l5.setBounds(30 , 210 , 150 , 25);
		l5.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l5);
		
		t9 = new JTextField();
		t9.setBounds(220, 210, 150, 25);
		t9.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(t9);
		
		JLabel l6 = new JLabel("Country :");
		l6.setBounds(30 , 250 , 150 , 25);
		l6.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l6);
		
		t4 = new JTextField();
		t4.setBounds(220, 250, 150, 25);
		t4.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(t4);
		
		JLabel l7 = new JLabel("Address :");
		l7.setBounds(30 , 290 , 150 , 25);
		l7.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l7);
		
		t5 = new JTextField();
		t5.setBounds(220, 290, 150, 25);
		t5.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(t5);
		
		JLabel l8 = new JLabel("Phone Number :");
		l8.setBounds(30 , 330 , 150 , 25);
		l8.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l8);
		
		t6 = new JTextField();
		t6.setBounds(220, 330, 150, 25);
		t6.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(t6);
		add(label2 = new JLabel());
		label2.setBounds(220, 355, 180, 12);
		label2.setFont(new Font("Tahoma", Font.BOLD,9));
		label2.setForeground(Color.RED);
		t6.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent ae) {
	            if (ae.getKeyChar() >= '0' && ae.getKeyChar() <= '9' || ae.getKeyChar() == '\b') {
	               t6.setEditable(true);
	               label2.setText("");
	            } else {
	               t6.setEditable(false);
	               label2.setText("* Enter only numeric digits(0-9)");
	            }
			}
			
		});
		
		JLabel l9 = new JLabel("Email :");
		l9.setBounds(30 , 370 , 150 , 25);
		l9.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(l9);
		
		t7 = new JTextField();
		t7.setBounds(220, 370, 150, 25);
		t7.setFont(new Font("Tahoma", Font.PLAIN,15));
		add(t7);
		
		b1 = new JButton("Update");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(70, 430, 100, 25);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setBounds(220, 430, 100, 25);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource
				("travel/management/system/icons/update.png"));
		Image i2 = i1.getImage().getScaledInstance(250, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l10 = new JLabel(i3);
		l10.setBounds(480, 20, 250, 450);
		add(l10);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.stmt.executeQuery
					("SELECT * FROM customer WHERE username = '" + this.username + "';");
			while(rs.next()) {
				t1.setText(rs.getString("username"));
				t2.setText(rs.getString("number"));
				t3.setText(rs.getString("name"));
				t4.setText(rs.getString("country"));
				t5.setText(rs.getString("address"));
				t6.setText(rs.getString("phone_number"));
				t7.setText(rs.getString("email"));
				t8.setText(rs.getString("id"));
				t9.setText(rs.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		new UpdateCustomer("Milan2210").setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1) {
			String username = t1.getText();
			String id = (String) t8.getText();
			float number = Float.parseFloat(t2.getText());
			String name = t3.getText();
			String radio = t9.getText();
			String country = t4.getText();
			String address = t5.getText();
			float phoneNumber = Float.parseFloat(t6.getText());
			String email = t7.getText();
			
			String sql = "UPDATE customer SET username = '" + username +
					"', id = '"+ id + "' , number='" + number +
					"',name= '" + name +"' ,gender= '"+radio+ "', country = '" + country +
					"' , address = '" + address + "' , phone_number = '" + phoneNumber + "', email = '" + email +"';";
			
			try {
				Conn c = new Conn();
				c.stmt.executeUpdate(sql);
				
				JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
				dispose();

			} catch (Exception ae) {
				ae.printStackTrace();
			}
		}else if(e.getSource() == b2) {
			dispose();
		}
		
	}
}
