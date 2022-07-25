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

    public boolean addUser(String userName, Double initialTransaction, String passWord, int branchID) {
        User newUser = new User(userName, initialTransaction, passWord, branchID);
        ArrayList<String> usersNameList = new ArrayList<>();
        usersNameList = getUsersNames();

        if (usersNameList.contains(userName)) {
            System.out.println("This User Already Exists in this Branch");
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
        System.out.println(usersNamesList);
        return usersNamesList;
    }


    public User getUser(String userName) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getUserName().equalsIgnoreCase(userName)) {
                return usersList.get(i);
            } else {
                continue;
            }
        }
        System.out.println("User " + userName + " not found");
        return null;
    }


}
