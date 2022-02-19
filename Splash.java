package travel.management.system;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash {

	public static void main(String[] args) {
		SplashFrame frame = new SplashFrame();
		frame.setVisible(true);
		int x = 1;
		for(int i = 0; i <= 700 ;i+=6 , x+=4) {
			frame.setLocation(700 - (x + i)/2,400 -(i/2));
			frame.setSize(x+i,i);
			try {
				Thread.sleep(10);
			}catch (Exception e) {}
		}
	}
}

@SuppressWarnings("serial")
class SplashFrame extends JFrame implements Runnable{
	Thread t1;
	
	public SplashFrame() {
		ImageIcon i1 = new ImageIcon(
				ClassLoader.getSystemResource("travel/management/system/icons/splash.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel l1 = new JLabel(i3);
		add(l1);
		
		
		t1 = new Thread(this);
		t1.start();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
//			this.setVisible(false);
			dispose();
			
			new Login();

		}catch (Exception e) {}
	}
}
