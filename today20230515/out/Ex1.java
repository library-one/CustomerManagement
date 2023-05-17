import java.awt.*;
import javax.swing.*;

class TimerThread extends Thread {
	JPanel panel = new JPanel();
	
	public TimerThread(JPanel p) {
		this.panel = p; 
	}

	// 스레드 코드. run()이 종료하면 스레드 종료
	public void run() {
		int n=0; // 타이머 카운트 값
		while(true) { // 무한 루프
			panel.repaint(); // paintComponent 메소드를 호출하기 위해
			
			try {
				Thread.sleep(500); // 0.5초동안 잠을 잔다.
			}
			catch(InterruptedException e) {	return;}
		}	
	}
}
public class RandomImage extends JFrame{
	ImagePanel ipanel = new ImagePanel();
	int x=50, y=50;
	public RandomImage() {
		setTitle("Thread클래스 실습1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setContentPane(ipanel);

		TimerThread th = new TimerThread(ipanel);
		
		setSize(250,250);
		setVisible(true);
		
		th.start(); // 타이머 스레드의 실행을 시작하게 한다.
	}
	class ImagePanel extends JPanel{
		ImageIcon icon = new ImageIcon("images/bubble.jpg");
		Image image = icon.getImage();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(image, (int)(Math.random() * 250), (int)(Math.random() * 250), this);
		}
	}
	
	public static void main(String[] args) {
		new RandomImage();

	}

}
