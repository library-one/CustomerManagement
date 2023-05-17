import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneBook extends JFrame {
    JTextField t1 = new JTextField(15);
    JTextField t2 = new JTextField(15);
    JTextArea a1 = new JTextArea(10,17);

    String[] major = {"소프트웨어공학과", "수학과", "간호학과", "경영학과", "일본어학과", "산업디자인학과"};
    PhoneBook() {
        setTitle("전화번호 관리");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JComboBox c1 = new JComboBox(major);
        c.add(new JLabel("성명"));
        c.add(t1);
        c.add(new JLabel("TEL"));
        c.add(t2);
        c.add(new JLabel("학과"));
        c.add(c1);

        c.add(new JScrollPane(a1));


        t1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JTextField tx1 = (JTextField)e.getSource();

                a1.append(tx1.getText() + "\n");

                tx1.setText(" ");

            }

        });

        t2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JTextField tx1 = (JTextField)e.getSource();

                a1.append(tx1.getText() + "\n");

                tx1.setText(" ");

            }

        });

        c1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                int index = cb.getSelectedIndex();
                a1.append(major[index]);
            }

        });

        setSize(240,300);

        setLocationRelativeTo(null);

        setVisible(true);

    }

    public static void main(String [] args) {

        new PhoneBook();

    }

}