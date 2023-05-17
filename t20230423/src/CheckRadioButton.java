
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckRadioButton extends JFrame {

    ImageIcon apple = new ImageIcon("images2/apple.jpg");
    ImageIcon banana = new ImageIcon("images2/banana.jpg");
    ImageIcon cherry = new ImageIcon("images2/cherry.jpg");

    String[] str = {"사과", "바나나", "체리"};
    JCheckBox[] fruits = new JCheckBox[str.length];
    JRadioButton[] fruits2 = new JRadioButton[str.length];
    JLabel image = new JLabel();
    JLabel sumLabel; // 더한 값 출력 레이블
    int sum = 0; // 가격의 합

    CheckRadioButton() {
        setTitle("실습1 예제 : 체크박스 + 라디오버튼 + 사진 출력"); // 프레임 타이틀
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 완전 종료
        setLocationRelativeTo(null); // 프레임 중간 위치 지정

        Container c = getContentPane(); // 컨텐트펜 생성
        c.setLayout(new FlowLayout()); // 플로우 레이아웃으로 셋팅
        Container d = getContentPane();

        // 레이블 생성
        JLabel la1 = new JLabel("사과 1,000원 / 바나나 5,000원 / 체리 20,000원");
        c.add(la1);
        sumLabel = new JLabel("합계 : 0원");

        ButtonGroup g = new ButtonGroup();

        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = new JCheckBox(str[i]);
            c.add(fruits[i]);
            fruits[i].addItemListener(new MyItemListener());
        }

        c.add(image); // 세팅한 이미지레이블을 컨텐트펜에 넣어줌
        c.add(sumLabel);

        for (int i = 0; i < fruits2.length; i++) {
            fruits2[i] = new JRadioButton(str[i]);
            fruits2[i].addItemListener(new MyItemListener2());
            g.add(fruits2[i]);
            c.add(fruits2[i]);
        }
        setSize(300, 300);
        setVisible(true); // 화면 보이게 하기

    }
    public static void main(String[] args) {
        new CheckRadioButton();

    }
    class MyItemListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (e.getItem() == fruits[0]) {
                    sum += 1000;
                } else if (e.getItem() == fruits[1]) {
                    sum += 5000;
                } else {
                    sum += 20000;
                }
            } else {
                if (e.getItem() == fruits[0]) {
                    sum -= 1000;
                } else if (e.getItem() == fruits[1]) {
                    sum -= 5000;
                } else {
                    sum -= 20000;
                }
            }
            sumLabel.setText("현재 " + sum + "원 입니다.");
        }

    }

    class MyItemListener2 implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (e.getItem() == fruits2[0]) {
                    image.setIcon(apple); // 해당 체크박스 인텍스에 맞는 사진 세팅
                } else if (e.getItem() == fruits2[1]) {
                    image.setIcon(banana); // 해당 체크박스 인텍스에 맞는 사진 세팅
                } else {
                    image.setIcon(cherry); // 해당 체크박스 인텍스에 맞는 사진 세팅
                }
            }
        }


    }
}