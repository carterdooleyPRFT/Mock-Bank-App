import GUI.HomePage;
import JDBCqueries.JDBCbranches;
import JDBCqueries.JDBCuser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Application {

    //Next to do: functional - fix error where user can be created even if branch is not found
    //Add Feature: depositing and withdrawal funds on the signed in page
    // Also add 'customer support' functionality
    // Add Security: password hashing to the database

    public static void main(String[] args) throws SQLException {
        new HomePage();
        JDBCuser seedUser = new JDBCuser();
        JDBCbranches seedBranches = new JDBCbranches();

        seedBranches.createBranchesTable();
        seedUser.createUserTable();
//        seedBranches.insertBranches("Section 704", 70401);
//        seedBranches.insertBranches("Section 705", 70592);
//        seedBranches.insertBranches("Section 701", 70192);
//        seedBranches.insertBranches("Section 702", 70292);
//       seedUser.getUser();
//        seedUser.dropUsersTable();
//        seedBranches.deleteBranchesTable();



    }
}
