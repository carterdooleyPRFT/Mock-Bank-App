package GUI;

import JDBCqueries.JDBCbranches;
import JDBCqueries.JDBCuser;
import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccount {

    JFrame createAccount = new JFrame("Create Account");
    JButton submit = new JButton(" Create Account");
    JTextField createUsername = new JTextField("Username");
    JPasswordField createPassword = new JPasswordField("Password");
    JTextField initialTransaction = new JTextField("Enter First Deposit Amount");
    JButton login = new JButton("Login");


    public CreateAccount() {

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUserName = createUsername.getText();
                String newPassword = String.valueOf(createPassword.getPassword());
                System.out.println(newPassword);
                double newInitialTransaction = Double.parseDouble(initialTransaction.getText());



                if (new JDBCuser().getUser(newUserName) == true) {
                    User newUser = new User(newUserName, newInitialTransaction, newPassword);
                    JDBCuser insUserData = new JDBCuser();
                    insUserData.newUser(newUser);
                    System.out.println("User " + newUserName + " Successfully created");
                } else {
                    System.out.println("User With that name Already exist");
                }






            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
            }
        });







        createAccount.setSize(350, 250);
        createAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAccount.setResizable(true);
        createAccount.setLayout(new FlowLayout());
        createAccount.add(createUsername);
        createAccount.add(createPassword);
        createAccount.add(initialTransaction);
        createAccount.add(submit);
        createAccount.add(login);
        createAccount.setVisible(true);

    }



}
