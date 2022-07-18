package Bank;

import Branch.Branch;

import java.util.ArrayList;

public class Bank {

    private final String name = "Credit Union";
    private ArrayList<Branch> branches = new ArrayList<Branch>();


    public boolean addBranch(String branchName, int branchZipcode) {
        Branch newBranch = new Branch(branchName, branchZipcode);
        ArrayList<String> branchNameList = new ArrayList<>();
        branchNameList = getBranchesNames();
        if (branchNameList.contains(branchName)) {
            System.out.println("This branch already exists");
            return false;
        } else {
            branches.add(newBranch);
            return true;
        }

    }

    public ArrayList<String> getBranchesNames() {
        ArrayList<String> branchesNamesList = new ArrayList<String>();
        String branchName;
        for (int i = 0; i < branches.size(); i++) {
            branchName = branches.get(i).getName();
            branchesNamesList.add(branchName);
        }
        System.out.println(branchesNamesList);
        return branchesNamesList;
    }



    public Branch getBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equalsIgnoreCase(branchName)) {
                return branches.get(i);
            } else {
                continue;
            }
        }
        System.out.println("Branch " + branchName + " not found");
        return null;
    }




}
