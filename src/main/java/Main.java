import Bank.Bank;
import Branch.Branch;
import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        final JFrame bankApp = new JFrame("Banking");




//        Create Account Button Control
        JButton createAccount = new JButton("Create Account");
        createAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankApp.dispose();
                new LoginPage();
            }
        });




//        Login Button Control
        JButton login = new JButton("Login");





        bankApp.setSize(350, 250);
        bankApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bankApp.setResizable(true);
        bankApp.add(createAccount);
        bankApp.add(login);
        bankApp.setLayout(new FlowLayout());
    }



}
