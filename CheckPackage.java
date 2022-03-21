package travel.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class CheckPackage extends JFrame {

	CheckPackage() {
		
		setBounds(400,150, 900 , 600);
		
		String[] package1 = new String[] 
				{"BRONZE PACKAGE","4 Days and 5 Nights", "Airport Assistance" ,
				"Half Day City Tour" , "Daily Buffet" , "Welcome Drinks on Arrival" ,
				"Full Day 3 Island Cruise" , "English Spraking Guide" , "BOOK NOW" ,
				"SUMMER SPECIAL", "Rs 12000/- only", "package1.jpg"};
		
		String[] package2 = new String[] 
				{"SILVER PACKAGE","5 Days and 6 Nights", "Toll Free and Entrace Free Ticket" ,
						"Meet and Greet at Airport" ,  "Welcome Drinks on Arrival" , "Night Safari" ,
						"Full Day 3 Island Cruise" , "Cruise With Dinner" , "BOOK NOW" ,
						"WINTER SPECIAL", "Rs 16000/- only", "package2.jpg"};
		
		String[] package3 = new String[] 
				{"GOLD PACKAGE","6 Days and 7 Nights", "Return Airfare" ,
						"Free clubbing, Horse Riding & other Games" ,  "Welcome Drinks on Arrival" , "Daily Buffet" ,
						"Stay in 5 Star Hotel" , "BBQ with Dinner" , "BOOK NOW" ,
						"WINTER SPECIAL", "Rs 22000/- only", "package3.jpg"};
		
		JPanel p1 = createPackage(package1 , new Color(205, 127, 50));
		JPanel p2 = createPackage(package2 , new Color(192,192,192));
		JPanel p3 = createPackage(package3 , new Color(255,204, 51));
		
		
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("Package 1", null , p1);
		pane.addTab("Package 2", null , p2);
		pane.addTab("Package 3", null , p3);
		add(pane , BorderLayout.CENTER);
		
		
	}
	
	public JPanel createPackage(String[] pack , Color clr) {
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(clr);
		
		JLabel l1 = new JLabel(pack[0]);
		l1.setBounds(50 , 5 , 300 , 30);
		l1.setFont(new Font("Tahoma",Font.PLAIN ,30));
		p.add(l1);
		
		JLabel l2 = new JLabel(pack[1]);
		l2.setBounds(30 , 60 , 300 , 30);
		l2.setFont(new Font("Tahoma",Font.PLAIN ,20));
		l2.setForeground(Color.RED);
		p.add(l2);
		
		JLabel l3 = new JLabel(pack[2]);
		l3.setBounds(30 , 110 , 300 , 30);
		l3.setFont(new Font("Tahoma",Font.PLAIN ,20));
		l3.setForeground(Color.BLUE);
		p.add(l3);
		
		JLabel l4 = new JLabel(pack[3]);
		l4.setBounds(30 , 160 , 300 , 30);
		l4.setFont(new Font("Tahoma",Font.PLAIN ,20));
		l4.setForeground(Color.RED);
		p.add(l4);
		
		JLabel l5 = new JLabel(pack[4]);
		l5.setBounds(30 , 210 , 300 , 30);
		l5.setFont(new Font("Tahoma",Font.PLAIN ,20));
		l5.setForeground(Color.BLUE);
		p.add(l5);
		
		JLabel l6 = new JLabel(pack[5]);
		l6.setBounds(30 , 260 , 300 , 30);
		l6.setFont(new Font("Tahoma",Font.PLAIN ,20));
		l6.setForeground(Color.RED);
		p.add(l6);
		
		JLabel l7 = new JLabel(pack[6]);
		l7.setBounds(30 , 310 , 300 , 30);
		l7.setFont(new Font("Tahoma",Font.PLAIN ,20));
		l7.setForeground(Color.BLUE);
		p.add(l7);
		
		JLabel l8 = new JLabel(pack[7]);
		l8.setBounds(30 , 360 , 300 , 30);
		l8.setFont(new Font("Tahoma",Font.PLAIN ,20));
		l8.setForeground(Color.RED);
		p.add(l8);
		
		JLabel l9 = new JLabel(pack[8]);
		l9.setBounds(30 , 430 , 300 , 30);
		l9.setFont(new Font("Tahoma",Font.PLAIN ,30));
		l9.setForeground(Color.BLUE);
		p.add(l9);
		
		JLabel l10 = new JLabel(pack[9]);
		l10.setBounds(300 , 470 , 300 , 30);
		l10.setFont(new Font("Tahoma",Font.PLAIN ,30));
		l10.setForeground(Color.BLUE);
		p.add(l10);
		
		JLabel l11 = new JLabel(pack[10]);
		l11.setBounds(650 , 470 , 300 , 30);
		l11.setFont(new Font("Tahoma",Font.PLAIN ,25));
		l11.setForeground(Color.BLUE);
		p.add(l11);
		
		ImageIcon i1 = new ImageIcon
				(ClassLoader.getSystemResource("travel/management/system/icons/"+ pack[11]));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l12 = new JLabel(i3);
		l12.setBounds(350, 20, 500, 300);
		p.add(l12);
		
		return p;
	}
	public static void main(String[] args) {
		new CheckPackage().setVisible(true);
	}
}
