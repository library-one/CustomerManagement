import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


public class BubbleGameFrame extends JFrame  {
    public BubbleGameFrame(){
        setTitle("버블 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocation(300,300);
        setVisible(true);
        Gamepanel p = new Gamepanel();
        setContentPane(p);
    }
    class Gamepanel extends JPanel{
        public Gamepanel(){
            setLayout(null);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    new BubbleThread(e.getX(),e.getY()).start();
                }
            });
        }
    }
    class BubbleThread extends Thread{
        JLabel buble;
        public BubbleThread(int bubblex, int bubbley){
            ImageIcon icon = new ImageIcon("images/buble.jpg");
            buble = new JLabel(icon);
            buble.setSize(icon.getIconWidth(),icon.getIconHeight());
            bubblex -= 5;
            buble.setLocation(bubblex,bubbley);
            add(buble);
            repaint();
        }
        public void run(){
            while(true){
                int x = buble.getX();
                int y = buble.getY() - 5 ;

                buble.setLocation(x,y);
                repaint();
                try{
                    sleep(200);
                }catch (InterruptedException e){return;}
            }

        }}
    public static void main(String[] args) {new BubbleGameFrame();}
}
