import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.*;

public class JRadionButton extends JFrame {
    int sum = 0; // 가격의 합
    String[] name = {"사과", "바나나", "체리"};
    JCheckBox[] fruits = new JCheckBox[name.length];
    JLabel sumlabel;

    JRadionButton() {
        setTitle("체크박스 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("사과 1000원, 바나나 5000원, 체리 20000원");
        Container c = getContentPane();
          /*  JCheckBox apple = new JCheckBox("사과");
            JCheckBox banana = new JCheckBox("바나나");
            JCheckBox cherry = new JCheckBox("체리");*/

        for (int i = 0; i < name.length; i++) {
            fruits[i] = new JCheckBox(name[i]);
            c.add(fruits[i]);
            fruits[i].addItemListener(new MyItemListener());

        }
        sumlabel = new JLabel("현재 0원 입니다.");
        c.setLayout(new FlowLayout());
        c.add(label);
        c.add(sumlabel);

        setSize(250, 300);
        setVisible(true);


    }

    public static void main(String[] args) {
        new JRadionButton();
    }

    class MyItemListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                if(e.getItem() == fruits[0])
                    sum += 1000;
                else if(e.getItem() == fruits[1])
                    sum += 5000;
                else
                    sum += 20000;
            }
            else {
                if(e.getItem() == fruits[0])
                    sum -= 1000;
                else if(e.getItem() == fruits[1])
                    sum -= 5000;
                else
                    sum -= 20000;
            }
            sumlabel.setText("현재 " + sum + "원 입니다.");
        }
    }

}