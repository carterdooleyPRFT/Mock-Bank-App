import Bank.Bank;
import Branch.Branch;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println(bank.addBranch("Section 705", 70503));
        System.out.println(bank.addBranch("Section 704", 70503));
        Branch thisBranch = bank.getBranch("section 705");
//        System.out.println(thisBranch.addUser("Carter Dooley", 5000.00));
        System.out.println(bank.getBranchesNames());
        Branch thisBranch1 = bank.getBranch("Section 704");
        System.out.println(thisBranch1.addUser("Carter Dooley", 5000.00));
    }



}
