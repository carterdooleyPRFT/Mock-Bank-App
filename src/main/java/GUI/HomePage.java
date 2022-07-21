package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {
    final JFrame bankApp = new JFrame("Banking");
    JButton login = new JButton("Login");
    JButton createAccount = new JButton("Create Account");


    public HomePage() {





//        Create Account Button Control

        createAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankApp.dispose();
                new CreateAccount();

            }
        });




//        Login Button Control

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankApp.dispose();
                new LoginPage();
            }
        });





        bankApp.setSize(350, 250);
        bankApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bankApp.setResizable(true);
        bankApp.add(createAccount);
        bankApp.add(login);
        bankApp.setLayout(new FlowLayout());
        bankApp.setVisible(true);
    }


}


