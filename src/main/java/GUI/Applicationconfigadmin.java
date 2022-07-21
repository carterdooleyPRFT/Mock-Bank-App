package GUI;

import Bank.Bank;
import JDBCqueries.JDBCbranches;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Applicationconfigadmin {

    final JFrame bankApp = new JFrame("Admin");
    JTextField branchName = new JTextField("Branch Name");
    JTextField zipcode = new JTextField("Branch Zipcode");
    JButton addBranch = new JButton("Add Branch");
    JLabel successAdmin = new JLabel("Admin Successfully Logged In");




    public Applicationconfigadmin() {



        addBranch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new JDBCbranches().getBranch(branchName.getText(), Integer.parseInt(zipcode.getText())) == true) {
                    new JDBCbranches().insertBranches(branchName.getText(), Integer.parseInt(zipcode.getText()));
                }
            }
        });



        bankApp.setSize(350, 250);
        bankApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bankApp.setResizable(true);
        bankApp.setLayout(new FlowLayout());
        bankApp.add(successAdmin);
        bankApp.add(branchName);
        bankApp.add(zipcode);
        bankApp.add(addBranch);
        bankApp.setVisible(true);


    }

}
