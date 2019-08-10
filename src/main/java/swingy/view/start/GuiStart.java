package swingy.view.start;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.*;

public class GuiStart extends JFrame {
    
    GuiStart()
    {

    }
    public static void guiview()
    {
        GuiStart te = new GuiStart();

        JTextArea Map = new JTextArea("wait for a map", 20, 35);
        JTextArea details = new JTextArea("wait for user details", 20, 20);

        Button b1 = new Button("up");
        Button b2 = new Button("down");
        Button b3 = new Button("left");
        Button b4 = new Button("right");


        JPanel panel = new JPanel();
        panel.add(Map);
        panel.add(details);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
    
        JFrame frame = new JFrame("SWINGY");

        frame.setLayout(new BorderLayout());
        
        frame.setSize(700, 500);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}