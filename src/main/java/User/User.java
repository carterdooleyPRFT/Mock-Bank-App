package User;

import java.util.ArrayList;

public class User {

    private String userName;
    private final Double initialTransaction;
    private String passWord;
    private Double accountTotal;
    private ArrayList<Double> transactions = new ArrayList<Double>();


    public User(String userName, Double initialTransaction, String passWord) {
        this.userName = userName;
        this.initialTransaction = initialTransaction;
        this.passWord = passWord;
        accountTotal = initialTransaction;
    }

    public String getUserName() {
        return userName;
    }

    public void depositFunds(Double amountToAdd){
        accountTotal += amountToAdd;
        transactions.add(amountToAdd);
        System.out.println(accountTotal);
    }

    public void withdrawFunds(Double amountToWithdraw){
        if (accountTotal - amountToWithdraw < 0) {
            System.out.println("Insufficient Funds");
        } else {
            accountTotal -= amountToWithdraw;
            transactions.add(amountToWithdraw);
            System.out.println(accountTotal);
        }
    }

    public Double getAccountTotal() {
        return accountTotal;
    }
}
