package GUI;

import JDBCqueries.JDBCuser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoggedInHome {


    final JFrame bankApp = new JFrame("Banking");
    JLabel success = new JLabel("Successfully Logged In");
    //Need functionality
    JButton deposit = new JButton("Deposit");
    JButton withdrawal = new JButton();



//Admin Log In: username = dual password = kimjim

    public LoggedInHome(final String username) {
        if (username.equals("dual")){
            new Applicationconfigadmin();

        } else {


            deposit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new loggedInDepsot().createDepositPage(username);
                    bankApp.dispose();
                }
            });

            JLabel name = new JLabel(username);
            double accountBalance = new JDBCuser().getAccountBalance(username);
            JLabel balanceLabel = new JLabel("$" + accountBalance);

            bankApp.setSize(350, 250);
            bankApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            bankApp.setResizable(true);
            bankApp.add(name);
            bankApp.add(success);
            bankApp.add(balanceLabel);
            bankApp.add(deposit);
            bankApp.setLayout(new FlowLayout());
            bankApp.setVisible(true);
        }

    }




}
