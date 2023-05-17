

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckAndRadio extends JFrame{

    ImageIcon apple = new ImageIcon("images/apple.jpg");
    ImageIcon banana = new ImageIcon("images/banana.jpg");
    ImageIcon cherry = new ImageIcon("images/cherry.jpg");

    String[] str = {"사과", "바나나", "체리"};
    JCheckBox[] fruits = new JCheckBox[str.length];
    JLabel image = new JLabel();
    JLabel sumLabel;
    Container c = getContentPane(); // 컨텐트펜 생성
    int sum = 0; // 가격의 합

    CheckAndRadio(){
        setTitle("실습1 예제"); // 프레임 타이틀
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 완전 종료
        setLocationRelativeTo(null); // 프레임 중간 위치 지정

        c.setLayout(new FlowLayout()); // 플로우 레이아웃으로 셋팅

        // 레이블 생성
        JLabel la1 = new JLabel("사과 1,000원 / 바나나 5,000원 / 체리 20,000원");
        c.add(la1);
        sumLabel = new JLabel("합계 : 0원");

        MyItemListener listener = new MyItemListener();

        for(int i=0;i<fruits.length;i++) {
            fruits[i] = new JCheckBox(str[i]);
            c.add(fruits[i]);
            fruits[i].addItemListener(listener);
        }

        c.add(sumLabel);

        setSize(450,300);
        setVisible(true); // 화면 보이게 하기

    }

    class MyItemListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                if(e.getItem() == fruits[0]) {
                    sum += 1000;
                    image.setIcon(apple);
                }
                else if(e.getItem() == fruits[1]) {
                    sum += 5000;
                    image.setIcon(banana);
                }
                else {
                    sum += 20000;
                    image.setIcon(cherry);
                }
            }
            else {
                if(e.getItem() == fruits[0]) {
                    sum -= 1000;
                    image.setIcon(apple);
                }
                else if(e.getItem() == fruits[1]) {
                    sum -= 5000;
                    image.setIcon(banana);
                }
                else {
                    sum -= 20000;
                    image.setIcon(cherry);
                }
            }
            c.add(image);
            sumLabel.setText("현재 " + sum + "원 입니다.");
        }

    }

    public static void main(String[] args) {
        new CheckAndRadio();

    }

}
