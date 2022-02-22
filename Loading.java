package travel.management.system;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class Loading extends JFrame implements Runnable{
	
	JProgressBar p;
	Thread t;
	String username;
	
	Loading(String username){
		
		this.username = username;
		t = new Thread(this);
		
		setBounds(450 ,250 , 650, 400);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("Travel and Tourism Application");
		l1.setBounds(85 , 20 ,600 ,40);
		l1.setFont(new Font("Raleway",Font.BOLD, 30));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		p = new JProgressBar();
		p.setBounds(160 ,80 , 300 , 25);
		p.setStringPainted(true);
		add(p);
		
		JLabel l2 = new JLabel("Please Wait...");
		l2.setBounds(255 , 110 ,120 ,25);
		l2.setFont(new Font("Tahoma",Font.BOLD, 16));
		l2.setForeground(Color.RED);
		add(l2);
		
		JLabel l3 = new JLabel("Welcome " + username);
		l3.setBounds(50 , 310 ,400 ,25);
		l3.setFont(new Font("Tahoma",Font.BOLD, 16));
		l3.setForeground(Color.RED);
		add(l3);
		
		t.start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Loading("").setVisible(true);
	}

	@Override
	public void run() {
		try {
			for(int i = 0 ; i <= 101 ;i++) {
				int m = p.getMaximum();
				int n = p.getValue();
				if(n < m) {
					p.setValue(p.getValue() + 1);
				}else {
					i = 101;
					dispose();
					new Dashboard(username).setVisible(true);;
				}
				Thread.sleep(50);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
