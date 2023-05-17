import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class PhoneGUI extends JFrame {
    JLabel la = new JLabel("결과창");
    phoneDBO pdb = new phoneDBO();
    JTextField middleID = new JTextField(15);
    JTextArea tf = new JTextArea();
    JTextField middleP = new JTextField(15);
    JButton slist = new JButton("리스트");
    JButton sadd = new JButton("추가");
    JButton supdate = new JButton("수정");
    JButton sdelete = new JButton("삭제");
    JButton send = new JButton("종료");
    JPanel cpane = new JPanel();
    JPanel cpane2 = new JPanel();

    public PhoneGUI() {

        setTitle("전화번호 관리");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        cpane.setLayout(new GridLayout(2, 2));

        cpane.add(new JLabel("이 름"));
        cpane.add(middleID);
        cpane.add(new JLabel("전화번호"));
        cpane.add(middleP);

        BtnAction bAction = new BtnAction();
        slist.addActionListener(bAction);
        sadd.addActionListener(bAction);
        supdate.addActionListener(bAction);
        sdelete.addActionListener(bAction);
        send.addActionListener(bAction);

        cpane2.add(slist);
        cpane2.add(sadd);
        cpane2.add(supdate);
        cpane2.add(sdelete);
        cpane2.add(send);

        add(la, BorderLayout.NORTH);
        add(cpane, BorderLayout.CENTER);
        add(cpane2, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PhoneGUI();
    }

    class BtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton b = (JButton) e.getSource();
            ArrayList<PhoneMathod> list = new ArrayList();
            if (b.getText().equals("리스트")) {
                new PhoneList();
                setVisible(false);
            }
            if (b.getText().equals("추가")) {
                String name = middleID.getText();
                String phone = middleP.getText();
                PhoneMathod ephone = new PhoneMathod(name, phone);
                boolean success = pdb.insertPhone(ephone);
                if (success)
                    la.setText("insert 성공");
                else
                    la.setText("insert 실패");
            }
            if (b.getText().equals("삭제")) {
                String name = middleID.getText();
                PhoneMathod ephone = new PhoneMathod();
                ephone.setName(name);
                boolean success = pdb.deletePhone(ephone);
                if (success)
                    la.setText("delete 성공");
                else
                    la.setText("delete 실패");
            }
            if (b.getText().equals("수정")) {
                String name = middleID.getText(); // 이름 받기
                String phone = middleP.getText(); // 전화번호 받기
                PhoneMathod ephone = new PhoneMathod(name, phone);
                boolean success = pdb.updatePhone(ephone);
                if (success)
                    la.setText("update 성공");
                else
                    la.setText("update 실패");
            }
            if (b.getText().equals("종료")) {
                System.exit(0);
            }
        }
    }
}
