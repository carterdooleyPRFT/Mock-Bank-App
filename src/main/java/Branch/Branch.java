package Branch;

import User.User;

import java.util.ArrayList;

public class Branch {

    private String name;
    private int zipCode;
    private ArrayList<User> usersList = new ArrayList<User>();


    public Branch(String name, int zipCode) {
        this.name = name;
        this.zipCode = zipCode;
    }


    public String getName() {
        return name;
    }


    public int getZipCode() {
        return zipCode;
    }

    public boolean addUser(String userName, double initialTransaction) {
        User newUser = new User(userName, initialTransaction);
        ArrayList<String> usersNameList = new ArrayList<>();
        usersNameList = getUsersNames();

        if (usersNameList.contains(userName)) {
            System.out.print("This User Already Exists in this Branch");
            return false;
        } else {
            usersList.add(newUser);
            return true;
        }

    }



    public ArrayList<String> getUsersNames() {
        ArrayList<String> usersNamesList = new ArrayList<String>();
        String userName;
        for (int i = 0; i < usersList.size(); i++) {
            userName = usersList.get(i).getUserName();
            usersNamesList.add(userName);
        }
        System.out.print(usersNamesList);
        return usersNamesList;
    }



}