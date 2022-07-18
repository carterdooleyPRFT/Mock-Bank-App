import Bank.Bank;
import Branch.Branch;
import User.User;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addBranch("Section 705", 70503);
        Branch thisBranch = bank.getBranch("Section 705");
        thisBranch.addUser("Carter", 500.00);
        User Carter = thisBranch.getUser("Carter");
        Carter.depositFunds(1.00);
        Carter.withdrawFunds(2.00);
    }



}
