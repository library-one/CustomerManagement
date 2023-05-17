import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuTest extends JFrame {
    JLabel imgLabel = new JLabel(); // 빈 레이블

    MenuTest() {
        setTitle("MenuTest");
        createMenu();
        getContentPane().add(imgLabel, BorderLayout.CENTER);
        setSize(250,200); setVisible(true);
    }

    void createMenu() {
        JMenuBar mb = new JMenuBar(); // 메뉴바 생성
        JMenuItem [] menuItem = new JMenuItem [3];
        JMenuItem [] menuColors = new JMenuItem[3];

        String[] itemTitle = {"Apple", "Banana", "Mango"};
        String[] colors = {"Red","Green","Blue"};
        JMenu screenMenu = new JMenu("Image");
        JMenu screenMenu2 = new JMenu("Colors");

        MenuActionListener listener = new MenuActionListener();
        for(int i=0; i<menuItem.length; i++) {
            menuItem[i] = new JMenuItem(itemTitle[i]);
            menuColors[i] = new JMenuItem(colors[i]);
            menuItem[i].addActionListener(listener);
            menuColors[i].addActionListener(listener);
            screenMenu.add(menuItem[i]);
            screenMenu2.add(menuColors[i]);
        }
        mb.add(screenMenu);
        mb.add(screenMenu2);
        setJMenuBar(mb); // 메뉴바를 프레임에 부착
    }
    class MenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch(cmd) { // 메뉴 아이템의 종류 구분
                case "Apple" :
                    imgLabel.setIcon(new
                            ImageIcon("images2/apple.jpg"));
                    break;
                case "Banana" :
                    imgLabel.setIcon(new
                            ImageIcon("images2/banana.jpg"));
                    break;
                case "Mango" :
                    imgLabel.setIcon(new
                            ImageIcon("images2/mango.jpg"));
                    break;
                case "Red" :
                    getContentPane().setBackground(Color.RED);
                    break;
                case "Green" :
                    getContentPane().setBackground(Color.GREEN);
                    break;
                case "Blue" :
                    getContentPane().setBackground(Color.BLUE);
                    break;
            }
        }
    }

    public static void main(String [] args) {
        new MenuTest();
    }
}
