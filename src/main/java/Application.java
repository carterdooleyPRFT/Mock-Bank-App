import GUI.HomePage;
import JDBCqueries.JDBCuser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Application {

    public static void main(String[] args) throws SQLException {
        new HomePage();
        JDBCuser seedUser = new JDBCuser();
        seedUser.createUserTable();

    }
}
