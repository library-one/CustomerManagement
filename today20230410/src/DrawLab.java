import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class DrawLab extends JFrame {
    DrawLab(){
        DrawPanel dpanel = new DrawPanel();
        setTitle("도형그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(dpanel);

    }
}
