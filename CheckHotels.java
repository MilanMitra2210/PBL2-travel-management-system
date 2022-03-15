package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CheckHotels extends JFrame implements Runnable {

	Thread t1;
	JLabel l1 , l2 , l3 , l4 , l5 , l6 , l7 , l8 ,l9 ,l10;
	JLabel[] label = new JLabel[] {
			l1 , l2 , l3 , l4 , l5 , l6 , l7 , l8 ,l9 ,l10	
	};
	JLabel caption;
	
	CheckHotels() {
		setBounds(350 , 100 , 900 , 700);
		
		ImageIcon i1 = null , i2 = null , i3 = null , i4 = null , i5 = null
				, i6 = null , i7 = null , i8 = null , i9 = null , i10 = null ;
		
		ImageIcon[] image = new ImageIcon[] {
				i1 , i2 , i3 , i4 , i5 , i6 , i7 , i8 , i9 , i10};
		
		Image j1 = null , j2 = null ,j3 = null , j4 = null , j5 = null,
				j6 = null,j7 = null,j8 = null,j9 = null,j10 = null;
		
		Image[] image2 = new Image[] {
				j1 , j2 ,j3 , j4 , j5,j6,j7,j8,j9,j10
		};
		caption = new JLabel();
		caption.setBounds(50, 550, 1000, 70);
		caption.setForeground(Color.WHITE);
		caption.setFont(new Font("Tahoma" , Font.PLAIN , 40));
		
		for(int i = 0 ; i < 9 ; i++) {
			image[i] = new ImageIcon(ClassLoader.getSystemResource(
					"travel/management/system/icons/hotel"+ (i+1) +".jpg"));
			image2[i] = image[i].getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
			image[i+1] = new ImageIcon(image2[i]);
			this.label[i] = new JLabel(image[i+1]);
			this.label[i].setBounds(0 ,0 , 900 , 700);
			add(this.label[i]);
		}
		
		t1 = new Thread(this);
		t1.start();
	}
	
	 public static void main(String[] args) {
		new CheckHotels().setVisible(true);;
	}

	@Override
	public void run() {
		String[] text = new String[] {
			"JW Marriot Hotel","Mandarin Oriental Hotel","Four Seasons Hotel","Radisson Hotel",
			"Classio Hotel","The Bay Club Hotel","Breeze Blows Hotel","Quick Stop Hotel",
			"Happy Mornings Motel","Moss View Hotel"
		};
		for(int i = 0 ; i < 9 ; i++) {
			this.label[i].setVisible(true);
			caption.setText(text[i]);
			this.label[i].add(caption);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.label[i].setVisible(false);
		}
	}
}
