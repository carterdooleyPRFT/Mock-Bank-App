package User;

import java.util.ArrayList;

public class User {

    private String userName;
    private final double initialTransaction;
    private double accountTotal;


    public User(String userName, double initialTransaction) {
        this.userName = userName;
        this.initialTransaction = initialTransaction;
    }

    public String getUserName() {
        return userName;
    }
}
