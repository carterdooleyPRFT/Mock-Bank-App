package JDBCqueries;

import User.User;

import javax.xml.transform.Result;
import java.io.FileReader;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class JDBCuser {




    public void createUserTable() {
        try {
            Properties prop = new Properties();

            String dbPropertiesFile = "src/main/JDBC/DBconfig.properties";

            FileReader fileReader = new FileReader(dbPropertiesFile);

            prop.load(fileReader);


            String dbDriverClass = prop.getProperty("db.driver.class");

            String dbConnUrl = prop.getProperty("db.conn.url");

            String dbUserName = prop.getProperty("db.username");

            String dbPassword = prop.getProperty("db.password");

            if (!"".equals(dbDriverClass) && !"".equals(dbConnUrl)) {
                /* Register jdbc driver class. */
                Class.forName(dbDriverClass);

                // Get database connection object.
                Connection dbConn = DriverManager.getConnection(dbConnUrl, dbUserName, dbPassword);

                // Get dtabase meta data.
                DatabaseMetaData dbMetaData = dbConn.getMetaData();

                // Get database name.
                String dbName = dbMetaData.getDatabaseProductName();

                // Get database version.
                String dbVersion = dbMetaData.getDatabaseProductVersion();

                System.out.println("Database Name : " + dbName);

                System.out.println("Database Version : " + dbVersion);

                Statement statement = dbConn.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS users" +
                        "(user_name TEXT, password TEXT, account_total DOUBLE PRECISION)");

                statement.close();
                dbConn.close();


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void newUser(User newUser) {
        String userName = newUser.getUserName();
        String password = newUser.getPassWord();
        double initTransaction = newUser.getInitialTransaction();
        try {
            Properties prop = new Properties();

            String dbPropertiesFile = "src/main/JDBC/DBconfig.properties";

            FileReader fileReader = new FileReader(dbPropertiesFile);

            prop.load(fileReader);


            String dbDriverClass = prop.getProperty("db.driver.class");

            String dbConnUrl = prop.getProperty("db.conn.url");

            String dbUserName = prop.getProperty("db.username");

            String dbPassword = prop.getProperty("db.password");

            if (!"".equals(dbDriverClass) && !"".equals(dbConnUrl)) {
                /* Register jdbc driver class. */
                Class.forName(dbDriverClass);

                // Get database connection object.
                Connection dbConn = DriverManager.getConnection(dbConnUrl, dbUserName, dbPassword);

                // Get dtabase meta data.
                DatabaseMetaData dbMetaData = dbConn.getMetaData();

                // Get database name.
                String dbName = dbMetaData.getDatabaseProductName();

                // Get database version.
                String dbVersion = dbMetaData.getDatabaseProductVersion();

                System.out.println("Database Name : " + dbName);

                System.out.println("Database Version : " + dbVersion);

                PreparedStatement statement = dbConn.prepareStatement("INSERT INTO users (user_name, password, account_total) VALUES(?, ?, ?)");
                statement.setString(1,userName);
                statement.setString(2, password);
                statement.setDouble(3,initTransaction);
                statement.executeUpdate();

                statement.close();
                dbConn.close();


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public boolean loginUser(String username, String password) {
        try {
            Properties prop = new Properties();

            String dbPropertiesFile = "src/main/JDBC/DBconfig.properties";

            FileReader fileReader = new FileReader(dbPropertiesFile);

            prop.load(fileReader);


            String dbDriverClass = prop.getProperty("db.driver.class");

            String dbConnUrl = prop.getProperty("db.conn.url");

            String dbUserName = prop.getProperty("db.username");

            String dbPassword = prop.getProperty("db.password");

            if (!"".equals(dbDriverClass) && !"".equals(dbConnUrl)) {
                /* Register jdbc driver class. */
                Class.forName(dbDriverClass);

                // Get database connection object.
                Connection dbConn = DriverManager.getConnection(dbConnUrl, dbUserName, dbPassword);

                // Get dtabase meta data.
                DatabaseMetaData dbMetaData = dbConn.getMetaData();

                // Get database name.
                String dbName = dbMetaData.getDatabaseProductName();

                // Get database version.
                String dbVersion = dbMetaData.getDatabaseProductVersion();

                System.out.println("Database Name : " + dbName);

                System.out.println("Database Version : " + dbVersion);

                PreparedStatement statement = dbConn.prepareStatement("SELECT password FROM users WHERE user_name =  '" + username.trim()+ "'");
                statement.execute();
                ResultSet result = statement.getResultSet();
                result.next();
                String checkPassword = result.getString("password");

                if (Objects.equals(checkPassword, password)){
                    System.out.print("User Logged in");
                        return true;
                    } else {
                        System.out.print("User not Found: Invalid password: " + checkPassword + " " + password);
                    }
                }



        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return false;
    }



}
