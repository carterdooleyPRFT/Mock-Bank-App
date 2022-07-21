package GUI;

import javax.swing.*;
import java.awt.*;

public class LoginPage {

    JFrame loginPage = new JFrame("Login");
    JButton submit = new JButton(" Submit Login");
    JTextField username = new JTextField("Username");
    JPasswordField password = new JPasswordField("Password");


    public LoginPage() {
        loginPage.setSize(350, 250);
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPage.setResizable(true);
        loginPage.setLayout(new FlowLayout());
        loginPage.add(username);
        loginPage.add(password);
        loginPage.add(submit);
        loginPage.setVisible(true);
    }





}
