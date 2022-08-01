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




    JFrame createAccount = new JFrame("Create Account");
    JButton submit = new JButton(" Create Account");
    JTextField createUsername = new JTextField("Username");
    JPasswordField createPassword = new JPasswordField("Password");
    JTextField initialTransaction = new JTextField("Enter First Deposit Amount");
    JButton login = new JButton("Login");
    JTextField branchChoice = new JTextField("Enter Branch");

    int branchIdForNewUser;
    final JDBCbranches getNames = new JDBCbranches();


    public void createBranchesCheckBox (){

        ArrayList<String> branchNames = getNames.getAllBranchNames();
        for (int i = 0; i < branchNames.size(); i++){
            final JList menuChoice = new JList();

            branchChoice.add(menuChoice);



        }
    }


    public CreateAccount() {

        ArrayList<String> branches = new ArrayList<>();
        branches = new JDBCbranches().getAllBranchNames();
        final ArrayList<String> finalBranches = branches;
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {





                String newUserName = createUsername.getText();
                String newPassword = String.valueOf(createPassword.getPassword());
                String branchName = branchChoice.getText();



                int conditioner = 0;
                for (int i = 0; i < finalBranches.size(); i++) {
                    if (finalBranches.get(i).trim().equals(branchName.trim())){
                        System.out.println("Successfully Found Branch " + branchName);
                        conditioner = 1;
                        break;

                    }
                    System.out.println("Could not find branch with name " + branchName);
                }

                if (conditioner == 0) {
                    newUserName = null;
                }

                System.out.println(newPassword);
                double newInitialTransaction = Double.parseDouble(initialTransaction.getText());




                final int branchID = new JDBCbranches().getBranchID(branchName);


                if (new JDBCuser().getUser(newUserName) && newUserName != null) {

                    User newUser = new User(newUserName, newInitialTransaction, newPassword, branchID);
                    JDBCuser insUserData = new JDBCuser();
                    insUserData.newUser(newUser);
                    System.out.println("User " + newUserName + " Successfully created");
                } else if (newUserName == null){
                    System.out.println("Please Enter Username or Enter Correct Branch Name");
                } else {
                    System.out.println("User With that name Already exist");
                }
                createAccount.dispose();
                new HomePage();






            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount.dispose();
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
        for (int i = 0; i < branches.size(); i++){
            JLabel names = new JLabel(branches.get(i));
            createAccount.add(names);
        }

        createBranchesCheckBox();
        createAccount.add(submit);
        createAccount.add(login);
        createAccount.setVisible(true);
        branchChoice.setVisible(true);

    }



}
