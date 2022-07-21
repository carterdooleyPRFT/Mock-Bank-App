package GUI;

import javax.swing.*;
import javax.swing.plaf.TextUI;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoggedInHome {
    final JFrame bankApp = new JFrame("Banking");
    JTextField success = new JTextField("Successfully Logged In");



    public LoggedInHome() {


        bankApp.setSize(350, 250);
        bankApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bankApp.setResizable(true);
        bankApp.add(success);
        bankApp.setLayout(new FlowLayout());
        bankApp.setVisible(true);
    }




}
