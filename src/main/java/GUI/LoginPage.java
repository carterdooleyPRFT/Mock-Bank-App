package GUI;

import JDBCqueries.JDBCuser;
import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {

    JFrame loginPage = new JFrame("Login");
    JButton submit = new JButton(" Submit Login");
    JTextField username = new JTextField("Username");
    JPasswordField password = new JPasswordField("Password");
    JButton home = new JButton("Home");



    public LoginPage() {

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginUserName = username.getText();
                String loginPassword = String.valueOf(password.getPassword());

                JDBCuser loginUser = new JDBCuser();
                boolean passed = loginUser.loginUser(loginUserName, loginPassword);

                if (passed) {
                    loginPage.dispose();
                     new LoggedInHome(loginUserName);

                }


            }
        });

        home.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                loginPage.dispose();
                new HomePage();
            }
        });









        loginPage.setSize(350, 250);
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPage.setResizable(true);
        loginPage.setLayout(new FlowLayout());
        loginPage.add(username);
        loginPage.add(password);
        loginPage.add(submit);
        loginPage.add(home);
        loginPage.setVisible(true);

        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }





}
