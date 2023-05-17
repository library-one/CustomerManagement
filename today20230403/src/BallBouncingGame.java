import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.Timer;

public class BallBouncingGame extends JPanel implements ActionListener, KeyListener {
    private int x = 0;
    private int y = 0;
    private int xSpeed = 2;
    private int ySpeed = 3;
    private int radius = 20;
    private Color ballColor = Color.RED;
    private Random random = new Random();

    private int paddleWidth = 80;
    private int paddleHeight = 10;
    private int paddleX = 150;
    private int paddleY = 350;

    private boolean gameRunning = true;

    private int ballSpeed = 5;
    private JScrollBar speedScrollbar = new JScrollBar(JScrollBar.HORIZONTAL, ballSpeed, 0, 1, 10);

    public BallBouncingGame() {
        Timer timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);

        speedScrollbar.addAdjustmentListener(e -> {
            ballSpeed = speedScrollbar.getValue();
        });

        add(speedScrollbar);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(ballColor);
        g.fillOval(x, y, radius, radius);

        g.setColor(Color.BLACK);
        g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);
    }

    public void actionPerformed(ActionEvent e) {
        if (gameRunning) {
            x += xSpeed * ballSpeed;
            y += ySpeed * ballSpeed;

            if (x <= 0 || x >= getWidth() - radius) {
                xSpeed = -xSpeed;
            }

            if (y <= 0) {
                ySpeed = -ySpeed;
            } else if (y >= getHeight() - radius - paddleHeight) {
                if (x >= paddleX && x <= paddleX + paddleWidth) {
                    ySpeed = -ySpeed;
                    ballColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                } else {
                    gameRunning = false;
                }
            }

            repaint();
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, radius, radius);
    }

    public Rectangle getPaddleBounds() {
        return new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight);
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            paddleX -= 20;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            paddleX += 20;
        }
        if (paddleX < 0) {
            paddleX = 0;
        } else if (paddleX > getWidth() - paddleWidth) {
            paddleX = getWidth() - paddleWidth;
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Bouncing Game");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.BallBouncingGame();
        BouncingGame game = new BallBouncingGame();
        frame.add(game);
        frame.setVisible(true);
    }
}