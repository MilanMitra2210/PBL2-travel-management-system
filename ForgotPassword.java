package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ForgotPassword extends JFrame implements ActionListener {

	JTextField t1 , t2 , t3 , t4 , t5;
	JButton b1 , b2 , b3;
	
	public ForgotPassword() {
		setBounds(400, 200, 850, 380);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource
				("travel/management/system/icons/forgotpassword.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l6 = new JLabel(i3);
		l6.setBounds(580, 70, 200, 200);
		add(l6);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(40,30,500,280);
		p1.setBackground(new Color(211,211,211));
		add(p1);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(40, 20, 100, 25);
		l1.setFont(new Font("SAN_SERIF",Font.BOLD, 15));
		p1.add(l1);
		
		t1 = new JTextField();
		t1.setBounds(220, 20, 150, 25);
		t1.setBorder(BorderFactory.createEmptyBorder());
		t1.setFont(new Font("SAN_SERIF",Font.PLAIN, 15));
		p1.add(t1);
		
		b1 = new JButton("Search");
		b1.setBackground(Color.gray);
		b1.setForeground(Color.WHITE);
		b1.setBounds(380, 20, 100, 25);
		b1.addActionListener(this);
		p1.add(b1);
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(40, 60, 100, 25);
		l2.setFont(new Font("SAN_SERIF",Font.BOLD, 15));
		p1.add(l2);
		
		t2 = new JTextField();
		t2.setBounds(220, 60, 150, 25);
		t2.setBorder(BorderFactory.createEmptyBorder());
		t2.setFont(new Font("SAN_SERIF",Font.PLAIN, 15));
		p1.add(t2);
		
		JLabel l3 = new JLabel("Your Security Question");
		l3.setBounds(40, 100, 180, 25);
		l3.setFont(new Font("SAN_SERIF",Font.BOLD, 15));
		p1.add(l3);
		
		t3 = new JTextField();
		t3.setBounds(220, 100, 250, 25);
		t3.setBorder(BorderFactory.createEmptyBorder());
		t3.setFont(new Font("SAN_SERIF",Font.PLAIN, 15));
		p1.add(t3);
		
		JLabel l4 = new JLabel("Answer");
		l4.setBounds(40, 140, 180, 25);
		l4.setFont(new Font("SAN_SERIF",Font.BOLD, 15));
		p1.add(l4);
		
		t4 = new JTextField();
		t4.setBounds(220, 140, 150, 25);
		t4.setBorder(BorderFactory.createEmptyBorder());
		t4.setFont(new Font("SAN_SERIF",Font.PLAIN, 15));
		p1.add(t4);
		
		b2 = new JButton("Retrieve");
		b2.setBackground(Color.gray);
		b2.setForeground(Color.WHITE);
		b2.setBounds(380, 140, 100, 25);
		b2.addActionListener(this);
		p1.add(b2);
		
		JLabel l5 = new JLabel("Password");
		l5.setBounds(40, 180, 180, 25);
		l5.setFont(new Font("SAN_SERIF",Font.BOLD, 15));
		p1.add(l5);
		
		t5 = new JTextField();
		t5.setBounds(220, 180, 150, 25);
		t5.setBorder(BorderFactory.createEmptyBorder());
		t5.setFont(new Font("SAN_SERIF",Font.PLAIN, 15));
		p1.add(t5);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.gray);
		b3.setForeground(Color.WHITE);
		b3.setBounds(200, 230, 100, 25);
		b3.addActionListener(this);
		p1.add(b3);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ForgotPassword().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Conn c = new Conn();
		
		if(e.getSource() == b1) {
			String sql = "SELECT * FROM account WHERE username = '" + t1.getText() + "'";
			try {
				
				ResultSet rs = c.stmt.executeQuery(sql);
				
				while (rs.next()) {
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("Security"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}else if(e.getSource() == b2) {
			
			String sql = "SELECT * FROM account WHERE username = '"
					+ t1.getText() + "' AND answer ='" + t4.getText() + "'";
			try {
				
				ResultSet rs = c.stmt.executeQuery(sql);
				while (rs.next()) {
					t5.setText(rs.getString("password"));
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}else if(e.getSource() == b3) {
			dispose();
			new Login();
		}
	}
}
