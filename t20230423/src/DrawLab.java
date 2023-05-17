import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DrawLab extends JFrame {
    int x = 100;
    int y = 100;
    char flag;
    DrawLab() {
        setTitle("사각형 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(300, 300);
        setLocationRelativeTo(null); // 결과창 가운데로
        setVisible(true);
    }
    public static void main(String [] args) {
        new DrawLab();

    }
// 사각형을 그릴 패널 작성. 이 패널에 마우스 리스너 구현
    class MyPanel extends JPanel {

        Point start=null; // 마우스의 시작점과 끝점
        public MyPanel() {
            MyMouseListener listener = new MyMouseListener();
            // listener를 아래 두 리스너로 공통으로 등록해야 한다.
            addMouseListener(listener);
            addMouseMotionListener(listener);
            Timer timer = new Timer(500, new TimerListenr());
            timer.start();

        }

        class MyMouseListener extends MouseAdapter {
            public void mousePressed(MouseEvent e) {
                x=e.getX();
                y=e.getY();
                //.fillRect(start,start,50,50);
                if(e.getButton()==MouseEvent.BUTTON1){ // 오른쪽 마우스 클릭
                    flag='L';
                }else{ // 왼쪽 마우스 클릭
                    flag='R';
                }
                repaint(); // 패널의 그리기 요청 주목
            }
            public void mouseDragged(MouseEvent e) {
            }
        }
    class TimerListenr implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(flag == 'L'){
                g.setColor(Color.blue);
                g.fillRect(x-25, y-25, 50, 50);
            }else if(flag=='R') {
                g.setColor(Color.red);
                g.fillOval(x-25, y-25, 50, 50);
            }
            else {
                x+=3;
                g.fillRect(x, y, 20, 20);
            }
        }
    }
}