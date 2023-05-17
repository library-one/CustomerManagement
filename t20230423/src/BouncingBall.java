import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBall extends JPanel implements ActionListener, AdjustmentListener {
    private int ballX = 100;  // 공의 초기 위치
    private int ballY = 100;
    private int ballSize = 50;
    private int ballSpeed = 10;  // 공의 초기 속도
    private Timer timer;
    private JScrollBar speedScrollBar;

    public BouncingBall() {
        setBackground(Color.WHITE);
        timer = new Timer(50, this);
        timer.start();

        // 스크롤바 생성 및 위치 조정
        speedScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, ballSpeed, 0, 1, 100);
        speedScrollBar.addAdjustmentListener(this);
        add(speedScrollBar, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        // 공의 이동
        ballX += ballSpeed;
        if (ballX + ballSize > getWidth() || ballX < 0) {
            ballSpeed = -ballSpeed;
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, ballSize, ballSize);
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        ballSpeed = e.getValue();  // 스크롤바의 값에 따라 공의 속도 조절
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.getContentPane().add(new BouncingBall());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}