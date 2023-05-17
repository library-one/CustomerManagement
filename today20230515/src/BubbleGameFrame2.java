import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


public class BubbleGameFrame2 extends JFrame  {
    public BubbleGameFrame2(){
        setTitle("버블 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocation(300,300);
        setVisible(true);
        Gamepanel p = new Gamepanel();
        setContentPane(p);
    }
    class Gamepanel extends JPanel{
        Timer timer = new Timer(1000,new TimerListener());
        public Gamepanel(){
            setLayout(null);
//            addMouseListener(new MouseAdapter() {
//                @Override
//                public void mousePressed(MouseEvent e) {
//                    new BubbleThread(e.getX(),e.getY()).start();
//                }
//            });
            timer.start();
        }

         class TimerListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BubbleThread((int)(Math.random()*300),0).start();
            }
        }
    }
    class BubbleThread extends Thread{
        JLabel buble;
        public BubbleThread(int bubblex, int bubbley){
            ImageIcon icon = new ImageIcon("images/buble.jpg");
            buble = new JLabel(icon);
            buble.setSize(icon.getIconWidth(),icon.getIconHeight());
            buble.setLocation(bubblex,bubbley);
            add(buble);
            repaint();
        }
        public void run(){
            while(true){
                int x = buble.getX();
                int y = buble.getY() + 5 ;

                buble.setLocation(x,y);
                repaint();
                try{
                    sleep(200);
                }catch (InterruptedException e){return;}
            }

        }
    }
    public static void main(String[] args) {new BubbleGameFrame2();}
}
