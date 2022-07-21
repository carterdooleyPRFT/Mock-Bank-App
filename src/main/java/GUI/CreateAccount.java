package GUI;

import javax.swing.*;
import java.awt.*;

public class CreateAccount {

    JFrame createAccount = new JFrame("Login");
    JButton submit = new JButton(" Submit Login");
    JTextField createUsername = new JTextField("Username");
    JPasswordField createPassword = new JPasswordField("Password");
    JTextField initialTransaction = new JTextField("Enter First Deposit Amount");


    public CreateAccount() {









        createAccount.setSize(350, 250);
        createAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAccount.setResizable(true);
        createAccount.setLayout(new FlowLayout());
        createAccount.add(createUsername);
        createAccount.add(createPassword);
        createAccount.add(initialTransaction);
        createAccount.add(submit);
        createAccount.setVisible(true);
    }



}
