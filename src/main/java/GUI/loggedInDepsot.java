package GUI;

import JDBCqueries.JDBCuser;
import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loggedInDepsot {


    //Need JDBCuser Put method for depositing into account

    JFrame depositPage = new JFrame("Deposit");
    JLabel welcomeMessage = new JLabel();
    JLabel enterAmountLabel = new JLabel("Enter The amount to deposit");
    JLabel invalidDeposit = new JLabel();
    JTextField enterAmount = new JTextField("Amount to deposit");
    JButton submitDeposit = new JButton("Submit");


    public void createDepositPage (final String username) {
        submitDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final double priorBalance = new JDBCuser().getAccountBalance(username);
                double depositAmount = 0;
                try {
                    depositAmount = Double.parseDouble(enterAmount.getText());
                    double newBalance = depositAmount + priorBalance;
                    new JDBCuser().updateAccountBalance(username, newBalance);
                    double newActualBalance = new JDBCuser().getAccountBalance(username);
                    welcomeMessage.setText("Your new Balance is: " + newActualBalance);
                    depositPage.add(welcomeMessage);

                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    welcomeMessage.setText("The input " + depositAmount + " is invalid. Please enter deposit amount in numerical form with no $ sign");
                    depositPage.add(welcomeMessage);
                }

            }
        });

        welcomeMessage.setText("Welcome " + username + ", Your Current Account balance is: $" + new JDBCuser().getAccountBalance(username));










        depositPage.setSize(350, 250);
        depositPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        depositPage.setResizable(true);
        depositPage.add(welcomeMessage);
        depositPage.add(enterAmountLabel);
        depositPage.add(enterAmount);
        depositPage.add(submitDeposit);
        depositPage.setLayout(new FlowLayout());
        depositPage.setVisible(true);

    }







}
