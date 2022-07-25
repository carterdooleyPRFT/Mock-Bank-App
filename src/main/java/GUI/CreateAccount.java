package GUI;

import JDBCqueries.JDBCbranches;
import JDBCqueries.JDBCuser;
import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateAccount {



//    Current State of creating an account:
//    Can list current branches in branches table, but checkbox feature does not work
//    Idea: Create text box to type in branch for creating account, and have the app list the possible branches, if no available branch is typed then error pop up.

    JFrame createAccount = new JFrame("Create Account");
    JButton submit = new JButton(" Create Account");
    JTextField createUsername = new JTextField("Username");
    JPasswordField createPassword = new JPasswordField("Password");
    JTextField initialTransaction = new JTextField("Enter First Deposit Amount");
    JButton login = new JButton("Login");
    JPopupMenu branchChoice = new JPopupMenu("Choose Your Branch");

    int branchIdForNewUser;
    final JDBCbranches getNames = new JDBCbranches();
    final JCheckBoxMenuItem menuChoice = new JCheckBoxMenuItem();

    public void createBranchesCheckBox (){

        ArrayList<String> branchNames = getNames.getAllBranchNames();
        for (int i = 0; i < branchNames.size(); i++){
            final JCheckBoxMenuItem menuChoice = new JCheckBoxMenuItem(branchNames.get(i));
            branchChoice.add(menuChoice);



        }
    }


    public CreateAccount() {


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {





                String newUserName = createUsername.getText();
                String newPassword = String.valueOf(createPassword.getPassword());
                int branchID = branchIdForNewUser;
                System.out.println(newPassword);
                double newInitialTransaction = Double.parseDouble(initialTransaction.getText());

                menuChoice.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(menuChoice.getText() + " Has Been Chosen");
                        branchIdForNewUser =  getNames.getBranchID(menuChoice.getText());
                    }
                });



                if (new JDBCuser().getUser(newUserName) == true) {
                    User newUser = new User(newUserName, newInitialTransaction, newPassword, branchID);
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
        createAccount.add(branchChoice);
        createBranchesCheckBox();
        createAccount.add(submit);
        createAccount.add(login);
        createAccount.setVisible(true);
        branchChoice.setVisible(true);

    }



}
